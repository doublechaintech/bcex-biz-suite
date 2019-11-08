package com.doublechaintech.bcex.wxappservicepageview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.doublechaintech.bcex.BaseViewPage;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BcexViewScope;
import com.doublechaintech.bcex.CustomBcexUserContextImpl;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.exam.Exam;
import com.doublechaintech.bcex.exam.ExamTokens;
import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.utils.MiscUtils;
import com.doublechaintech.bcex.wxappservice.DBQuery;
import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.utils.MapUtil;
import com.terapico.utils.TextUtil;

public class ScoreboardPage extends BaseViewPage{
	private static final long serialVersionUID = 1L;
	private static BcexViewScope ViewScope = BcexViewScope.getInstance();
	protected static final SerializeScope SCOPE = SerializeScope.INCLUDE()
			.field("title")
			.field("popup")
			.field("toast", SerializeScope.EXCLUDE())
			.field("refreshAction")
			.field("actions", SerializeScope.EXCLUDE())
			.field("actionList")
			// 
			.field("worldRanking")
			.field("totalScore")
			.field("examScore")
			.field("question")
			.field("imageUrl")
			.field("name")
			.field("brief")
			.field("list", SerializeScope.EXCLUDE())
			;
	@Override
	protected SerializeScope getSerializeScope() {
		return SCOPE;
	}

	public String getPageTitle() {
		if (pageTitle == null) {
			return "scoreboard";
		}
		return pageTitle;
	}
	@Override
	public void assemblerContent(BcexUserContext userContext, String requestName)throws Exception {
		CustomBcexUserContextImpl ctx = (CustomBcexUserContextImpl)userContext;
		setPageTitle("得分榜");
		
		List<Object> scoreList = new ArrayList<>();
		String examId = ctx.getQuizId();
		if (!TextUtil.isBlank(examId)) {
			assemblerExamScore(ctx, examId, scoreList);
		}
		
		assemblerWorldRankScore(ctx, scoreList);
		
		int totalScore = MiscUtils.calcUserTotalScore(ctx, ctx.getCurrentUserInfo());
		int wordRanking = MiscUtils.findUserWorldRank(ctx, totalScore);
		set("worldRanking", wordRanking+"");
		set("totalScore", totalScore+"");
		SmartList<Question> qlist = new DBQuery().queryQuestionListOfRandom(ctx, 1);
		set("question", qlist.first().getTopic());
		set("imageUrl", ctx.getCurrentUserInfo().getAvarta());
		set("name", ctx.getCurrentUserInfo().getName());
		set("brief", "共进行了8场考试");
		
		set("list", scoreList);
	}

	private void assemblerWorldRankScore(CustomBcexUserContextImpl ctx, List<Object> scoreList) {
		String sql = "select WU.name, WU.avarta as imageUrl, sum(E.score)  as totalScore from exam_data E\n" + 
				"	left join wechat_user_data WU on E.user = WU.id " + 
				"	group by WU.id" + 
				"    order by totalScore desc " + 
				"    limit 5";
		List<Map<String, Object>> list = ctx.dao().queryAsMapList(sql, new Object[] {});
		for(int i = 0;i < 5;i++) {
			
			Map<String, Object> data = list.get(i);
			data.put("wordRanking", scoreList.size()+1+"");
			data.put("id", i+1);
			scoreList.add(data);
		}
		
	}

	private void assemblerExamScore(CustomBcexUserContextImpl ctx, String examId, List<Object> scoreList) throws Exception {
		Exam exam = ctx.getDAOGroup().getExamDAO().load(examId, ExamTokens.empty());
		set("examScore", exam.getScore());
		
		int totalScore = MiscUtils.calcUserTotalScore(ctx, ctx.getCurrentUserInfo());
		int wordRanking = MiscUtils.findUserWorldRank(ctx, totalScore);
		Map<String, Object> data = MapUtil.put("id", scoreList.size()+1)
				.put("worldRanking", wordRanking+"")
				.put("imageUrl", ctx.getCurrentUserInfo().getAvarta())
				.put("name", ctx.getCurrentUserInfo().getName())
				.put("totalScore", totalScore+"")
				.into_map();
		scoreList.add(data);
	}
}