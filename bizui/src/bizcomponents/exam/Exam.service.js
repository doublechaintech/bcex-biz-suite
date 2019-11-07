
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}examManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}examManager/loadExam/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateStatus = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}examManager/requestCandidateStatus/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherStatus = (id, parameters) => {
  const url = `${PREFIX}examManager/transferToAnotherStatus/id/anotherStatusId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateUser = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}examManager/requestCandidateUser/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherUser = (id, parameters) => {
  const url = `${PREFIX}examManager/transferToAnotherUser/id/anotherUserId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addUserAnswer = (targetObjectId, parameters) => {
  const url = `${PREFIX}examManager/addUserAnswer/examId/topic/userSelect/questionId/tokensExpr/`
  const examId = targetObjectId
  const requestParameters = { ...parameters, examId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateUserAnswer = (targetObjectId, parameters) => {
  const url = `${PREFIX}examManager/updateUserAnswerProperties/examId/id/topic/userSelect/tokensExpr/`
  const examId = targetObjectId
  const requestParameters = { ...parameters, examId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeUserAnswerList = (targetObjectId, parameters) => {
  const url = `${PREFIX}examManager/removeUserAnswerList/examId/userAnswerIds/tokensExpr/`
  const requestParameters = { ...parameters, examId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addFaultAnswer = (targetObjectId, parameters) => {
  const url = `${PREFIX}examManager/addFaultAnswer/examId/topic/yourAnswer/rightAnswer/userId/tokensExpr/`
  const examId = targetObjectId
  const requestParameters = { ...parameters, examId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateFaultAnswer = (targetObjectId, parameters) => {
  const url = `${PREFIX}examManager/updateFaultAnswerProperties/examId/id/topic/yourAnswer/rightAnswer/tokensExpr/`
  const examId = targetObjectId
  const requestParameters = { ...parameters, examId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeFaultAnswerList = (targetObjectId, parameters) => {
  const url = `${PREFIX}examManager/removeFaultAnswerList/examId/faultAnswerIds/tokensExpr/`
  const requestParameters = { ...parameters, examId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}examService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}examService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}examService/process/`,
    data,
  })
}

const ExamService = { view,
  load,
  addUserAnswer,
  addFaultAnswer,
  updateUserAnswer,
  updateFaultAnswer,
  removeUserAnswerList,
  removeFaultAnswerList,
  requestCandidateStatus,
  requestCandidateUser,
  transferToAnotherStatus,
  transferToAnotherUser, listFunctions, saveRequest, processRequest}
export default ExamService

