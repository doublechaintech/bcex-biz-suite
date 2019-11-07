
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}answerQuestionManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}answerQuestionManager/loadAnswerQuestion/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateUser = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}answerQuestionManager/requestCandidateUser/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherUser = (id, parameters) => {
  const url = `${PREFIX}answerQuestionManager/transferToAnotherUser/id/anotherUserId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateQuestion = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}answerQuestionManager/requestCandidateQuestion/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherQuestion = (id, parameters) => {
  const url = `${PREFIX}answerQuestionManager/transferToAnotherQuestion/id/anotherQuestionId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateChangeRequest = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}answerQuestionManager/requestCandidateChangeRequest/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherChangeRequest = (id, parameters) => {
  const url = `${PREFIX}answerQuestionManager/transferToAnotherChangeRequest/id/anotherChangeRequestId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}answerQuestionService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}answerQuestionService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}answerQuestionService/process/`,
    data,
  })
}

const AnswerQuestionService = { view,
  load,
  requestCandidateUser,
  requestCandidateQuestion,
  requestCandidateChangeRequest,
  transferToAnotherUser,
  transferToAnotherQuestion,
  transferToAnotherChangeRequest, listFunctions, saveRequest, processRequest}
export default AnswerQuestionService

