
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}wechatUserManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}wechatUserManager/loadWechatUser/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}wechatUserManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  const url = `${PREFIX}wechatUserManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addAnswerQuestion = (targetObjectId, parameters) => {
  const url = `${PREFIX}wechatUserManager/addAnswerQuestion/wechatUserId/nickName/questionId/answer/changeRequestId/tokensExpr/`
  const wechatUserId = targetObjectId
  const requestParameters = { ...parameters, wechatUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAnswerQuestion = (targetObjectId, parameters) => {
  const url = `${PREFIX}wechatUserManager/updateAnswerQuestionProperties/wechatUserId/id/nickName/answer/tokensExpr/`
  const wechatUserId = targetObjectId
  const requestParameters = { ...parameters, wechatUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAnswerQuestionList = (targetObjectId, parameters) => {
  const url = `${PREFIX}wechatUserManager/removeAnswerQuestionList/wechatUserId/answerQuestionIds/tokensExpr/`
  const requestParameters = { ...parameters, wechatUserId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addWechatLoginInfo = (targetObjectId, parameters) => {
  const url = `${PREFIX}wechatUserManager/addWechatLoginInfo/wechatUserId/appId/openId/sessionKey/tokensExpr/`
  const wechatUserId = targetObjectId
  const requestParameters = { ...parameters, wechatUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateWechatLoginInfo = (targetObjectId, parameters) => {
  const url = `${PREFIX}wechatUserManager/updateWechatLoginInfoProperties/wechatUserId/id/appId/openId/sessionKey/tokensExpr/`
  const wechatUserId = targetObjectId
  const requestParameters = { ...parameters, wechatUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeWechatLoginInfoList = (targetObjectId, parameters) => {
  const url = `${PREFIX}wechatUserManager/removeWechatLoginInfoList/wechatUserId/wechatLoginInfoIds/tokensExpr/`
  const requestParameters = { ...parameters, wechatUserId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addExam = (targetObjectId, parameters) => {
  const url = `${PREFIX}wechatUserManager/addExam/wechatUserId/name/statusId/score/tokensExpr/`
  const wechatUserId = targetObjectId
  const requestParameters = { ...parameters, wechatUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateExam = (targetObjectId, parameters) => {
  const url = `${PREFIX}wechatUserManager/updateExamProperties/wechatUserId/id/name/score/tokensExpr/`
  const wechatUserId = targetObjectId
  const requestParameters = { ...parameters, wechatUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeExamList = (targetObjectId, parameters) => {
  const url = `${PREFIX}wechatUserManager/removeExamList/wechatUserId/examIds/tokensExpr/`
  const requestParameters = { ...parameters, wechatUserId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addFaultAnswer = (targetObjectId, parameters) => {
  const url = `${PREFIX}wechatUserManager/addFaultAnswer/wechatUserId/topic/yourAnswer/rightAnswer/examId/tokensExpr/`
  const wechatUserId = targetObjectId
  const requestParameters = { ...parameters, wechatUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateFaultAnswer = (targetObjectId, parameters) => {
  const url = `${PREFIX}wechatUserManager/updateFaultAnswerProperties/wechatUserId/id/topic/yourAnswer/rightAnswer/tokensExpr/`
  const wechatUserId = targetObjectId
  const requestParameters = { ...parameters, wechatUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeFaultAnswerList = (targetObjectId, parameters) => {
  const url = `${PREFIX}wechatUserManager/removeFaultAnswerList/wechatUserId/faultAnswerIds/tokensExpr/`
  const requestParameters = { ...parameters, wechatUserId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}wechatUserService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}wechatUserService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}wechatUserService/process/`,
    data,
  })
}

const WechatUserService = { view,
  load,
  addAnswerQuestion,
  addWechatLoginInfo,
  addExam,
  addFaultAnswer,
  updateAnswerQuestion,
  updateWechatLoginInfo,
  updateExam,
  updateFaultAnswer,
  removeAnswerQuestionList,
  removeWechatLoginInfoList,
  removeExamList,
  removeFaultAnswerList,
  requestCandidatePlatform,
  transferToAnotherPlatform, listFunctions, saveRequest, processRequest}
export default WechatUserService

