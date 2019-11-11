package com.doublechaintech.bcex.wxappservicepageview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.doublechaintech.bcex.BaseViewPage;
import com.doublechaintech.bcex.BcexBaseConstants;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BcexViewScope;
import com.doublechaintech.bcex.CustomBcexUserContextImpl;
import com.doublechaintech.bcex.exam.Exam;
import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.utils.BcexConstants;
import com.doublechaintech.bcex.wxappservice.WxappServiceViewService;
import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.utils.MapUtil;
import com.terapico.utils.TextUtil;

public class AnswerSheetPage extends BaseViewPage{
	private static final long serialVersionUID = 1L;
	private static BcexViewScope ViewScope = BcexViewScope.getInstance();
	protected static final SerializeScope SCOPE = SerializeScope.EXCLUDE();
			//SerializeScope.INCLUDE()
//			.field("title")
//			.field("popup")
//			.field("toast", SerializeScope.EXCLUDE())
//			.field("refreshAction")
//			.field("actions", SerializeScope.EXCLUDE())
//			.field("actionList")
//			.field("question",  SerializeScope.INCLUDE()
//					.field(Question.ID_PROPERTY)
//					.field(Question.TOPIC_PROPERTY)
//					.field(Question.LEVEL_PROPERTY)
//					.field(Question.RIGHT_ANSWER_PROPERTY)
//				  )
//			.field("questions", SerializeScope.EXCLUDE())
//			.field("examId")
//			;
	private static final java.util.Map<String, Object> EO = null;
	@Override
	protected SerializeScope getSerializeScope() {
		return SCOPE;
	}

	public String getPageTitle() {
		if (pageTitle == null) {
			return "答题";
		}
		return pageTitle;
	}
	@Override
	public void assemblerContent(BcexUserContext userContext, String requestName)throws Exception {
		CustomBcexUserContextImpl ctx = (CustomBcexUserContextImpl)userContext;
		Exam exam = ctx.getExam();
		List<Object> result = new ArrayList<>();
		exam.getUserAnswerList().forEach(ans->{
			try {
				Question question = ctx.getDAOGroup().getQuestionDAO().load(ans.getQuestion().getId(), EO);
				List<Map<String, Object>> selections = new ArrayList<>();
				addSelection(ctx, selections, ans.getId(), "A", question.getOptionA());
				addSelection(ctx, selections, ans.getId(), "B", question.getOptionB());
				addSelection(ctx, selections, ans.getId(), "C", question.getOptionC());
				addSelection(ctx, selections, ans.getId(), "D", question.getOptionD());
				addSelection(ctx, selections, ans.getId(), "E", question.getOptionE());
				Collections.shuffle(selections);
				
				Map<String, Object> data = MapUtil.put("id", ans.getId())
					.put("title", question.getTopic())
					.put("correctAnswerId", question.getRightAnswer())
					.put("choices", selections)
					.into_map();
				
				result.add(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		set("questions", result);
		set("examId", exam.getId());
	}

	private void addSelection(CustomBcexUserContextImpl ctx, List<Map<String, Object>> selections, String uaId,
			String key, String text) {
		if (TextUtil.isBlank(text)) {
			return;
		}
		selections.add( MapUtil.put("id", key)
				.put("text", text)
				// .put(BcexConstants.X_LINK_TO_URL, WxappServiceViewService.makeAnswerQuestionUrl(ctx, uaId, key))
				.into_map()
				);
	}
	
	
	
}
