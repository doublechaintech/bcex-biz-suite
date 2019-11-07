
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}changeRequestManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}changeRequestManager/loadChangeRequest/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateRequestType = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}changeRequestManager/requestCandidateRequestType/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherRequestType = (id, parameters) => {
  const url = `${PREFIX}changeRequestManager/transferToAnotherRequestType/id/anotherRequestTypeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}changeRequestManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  const url = `${PREFIX}changeRequestManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addRegisteration = (targetObjectId, parameters) => {
  const url = `${PREFIX}changeRequestManager/addRegisteration/changeRequestId/nickName/avarta/tokensExpr/`
  const changeRequestId = targetObjectId
  const requestParameters = { ...parameters, changeRequestId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRegisteration = (targetObjectId, parameters) => {
  const url = `${PREFIX}changeRequestManager/updateRegisterationProperties/changeRequestId/id/nickName/avarta/tokensExpr/`
  const changeRequestId = targetObjectId
  const requestParameters = { ...parameters, changeRequestId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRegisterationList = (targetObjectId, parameters) => {
  const url = `${PREFIX}changeRequestManager/removeRegisterationList/changeRequestId/registerationIds/tokensExpr/`
  const requestParameters = { ...parameters, changeRequestId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addStartExam = (targetObjectId, parameters) => {
  const url = `${PREFIX}changeRequestManager/addStartExam/changeRequestId/nickName/tokensExpr/`
  const changeRequestId = targetObjectId
  const requestParameters = { ...parameters, changeRequestId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateStartExam = (targetObjectId, parameters) => {
  const url = `${PREFIX}changeRequestManager/updateStartExamProperties/changeRequestId/id/nickName/tokensExpr/`
  const changeRequestId = targetObjectId
  const requestParameters = { ...parameters, changeRequestId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeStartExamList = (targetObjectId, parameters) => {
  const url = `${PREFIX}changeRequestManager/removeStartExamList/changeRequestId/startExamIds/tokensExpr/`
  const requestParameters = { ...parameters, changeRequestId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addAnswerQuestion = (targetObjectId, parameters) => {
  const url = `${PREFIX}changeRequestManager/addAnswerQuestion/changeRequestId/nickName/userId/questionId/answer/tokensExpr/`
  const changeRequestId = targetObjectId
  const requestParameters = { ...parameters, changeRequestId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAnswerQuestion = (targetObjectId, parameters) => {
  const url = `${PREFIX}changeRequestManager/updateAnswerQuestionProperties/changeRequestId/id/nickName/answer/tokensExpr/`
  const changeRequestId = targetObjectId
  const requestParameters = { ...parameters, changeRequestId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAnswerQuestionList = (targetObjectId, parameters) => {
  const url = `${PREFIX}changeRequestManager/removeAnswerQuestionList/changeRequestId/answerQuestionIds/tokensExpr/`
  const requestParameters = { ...parameters, changeRequestId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}changeRequestService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}changeRequestService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}changeRequestService/process/`,
    data,
  })
}

const ChangeRequestService = { view,
  load,
  addRegisteration,
  addStartExam,
  addAnswerQuestion,
  updateRegisteration,
  updateStartExam,
  updateAnswerQuestion,
  removeRegisterationList,
  removeStartExamList,
  removeAnswerQuestionList,
  requestCandidateRequestType,
  requestCandidatePlatform,
  transferToAnotherRequestType,
  transferToAnotherPlatform, listFunctions, saveRequest, processRequest}
export default ChangeRequestService

