

import React from 'react'
import { Router, Route, Switch } from 'dva/router'
import { LocaleProvider } from 'antd'
import zhCN from 'antd/lib/locale-provider/zh_CN'
// import enUS from 'antd/lib/locale-provider/en_US'
import Launcher from '../launcher/Launcher'
import ForgetPasswordForm from '../launcher/ForgetPasswordForm'

import GlobalComponents from './'


function RouterConfig({ history }) {

	const {PlatformBizApp} = GlobalComponents
	const {ChangeRequestTypeBizApp} = GlobalComponents
	const {ChangeRequestBizApp} = GlobalComponents
	const {RegisterationBizApp} = GlobalComponents
	const {StartExamBizApp} = GlobalComponents
	const {AnswerQuestionBizApp} = GlobalComponents
	const {ExamStatusBizApp} = GlobalComponents
	const {QuestionBizApp} = GlobalComponents
	const {ExamRankingBizApp} = GlobalComponents
	const {AnswerBizApp} = GlobalComponents
	const {WechatUserBizApp} = GlobalComponents
	const {ExamBizApp} = GlobalComponents
	const {UserAnswerBizApp} = GlobalComponents
	const {FaultAnswerBizApp} = GlobalComponents
	const {UserDomainBizApp} = GlobalComponents
	const {UserWhiteListBizApp} = GlobalComponents
	const {SecUserBizApp} = GlobalComponents
	const {SecUserBlockingBizApp} = GlobalComponents
	const {UserAppBizApp} = GlobalComponents
	const {QuickLinkBizApp} = GlobalComponents
	const {ListAccessBizApp} = GlobalComponents
	const {ObjectAccessBizApp} = GlobalComponents
	const {LoginHistoryBizApp} = GlobalComponents
	const {GenericFormBizApp} = GlobalComponents
	const {FormMessageBizApp} = GlobalComponents
	const {FormFieldMessageBizApp} = GlobalComponents
	const {FormFieldBizApp} = GlobalComponents
	const {FormActionBizApp} = GlobalComponents
	const {CandidateContainerBizApp} = GlobalComponents
	const {CandidateElementBizApp} = GlobalComponents



  return (
    <LocaleProvider locale={zhCN}>
      <Router history={history}>
        <Switch>
          <Route path="/home" component={Launcher} />
          <Route path="/forgetpass" component={ForgetPasswordForm} />
          <Route path="/platform/" component={PlatformBizApp} />
          <Route path="/changeRequestType/" component={ChangeRequestTypeBizApp} />
          <Route path="/changeRequest/" component={ChangeRequestBizApp} />
          <Route path="/registeration/" component={RegisterationBizApp} />
          <Route path="/startExam/" component={StartExamBizApp} />
          <Route path="/answerQuestion/" component={AnswerQuestionBizApp} />
          <Route path="/examStatus/" component={ExamStatusBizApp} />
          <Route path="/question/" component={QuestionBizApp} />
          <Route path="/examRanking/" component={ExamRankingBizApp} />
          <Route path="/answer/" component={AnswerBizApp} />
          <Route path="/wechatUser/" component={WechatUserBizApp} />
          <Route path="/exam/" component={ExamBizApp} />
          <Route path="/userAnswer/" component={UserAnswerBizApp} />
          <Route path="/faultAnswer/" component={FaultAnswerBizApp} />
          <Route path="/userDomain/" component={UserDomainBizApp} />
          <Route path="/userWhiteList/" component={UserWhiteListBizApp} />
          <Route path="/secUser/" component={SecUserBizApp} />
          <Route path="/secUserBlocking/" component={SecUserBlockingBizApp} />
          <Route path="/userApp/" component={UserAppBizApp} />
          <Route path="/quickLink/" component={QuickLinkBizApp} />
          <Route path="/listAccess/" component={ListAccessBizApp} />
          <Route path="/objectAccess/" component={ObjectAccessBizApp} />
          <Route path="/loginHistory/" component={LoginHistoryBizApp} />
          <Route path="/genericForm/" component={GenericFormBizApp} />
          <Route path="/formMessage/" component={FormMessageBizApp} />
          <Route path="/formFieldMessage/" component={FormFieldMessageBizApp} />
          <Route path="/formField/" component={FormFieldBizApp} />
          <Route path="/formAction/" component={FormActionBizApp} />
          <Route path="/candidateContainer/" component={CandidateContainerBizApp} />
          <Route path="/candidateElement/" component={CandidateElementBizApp} />
          <Route path="/" component={Launcher} />
        </Switch>
      </Router>
    </LocaleProvider>
  )
}

export default RouterConfig










