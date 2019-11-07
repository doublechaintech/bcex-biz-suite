
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}questionManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}questionManager/loadQuestion/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}questionManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  const url = `${PREFIX}questionManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addAnswerQuestion = (targetObjectId, parameters) => {
  const url = `${PREFIX}questionManager/addAnswerQuestion/questionId/nickName/userId/answer/changeRequestId/tokensExpr/`
  const questionId = targetObjectId
  const requestParameters = { ...parameters, questionId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAnswerQuestion = (targetObjectId, parameters) => {
  const url = `${PREFIX}questionManager/updateAnswerQuestionProperties/questionId/id/nickName/answer/tokensExpr/`
  const questionId = targetObjectId
  const requestParameters = { ...parameters, questionId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAnswerQuestionList = (targetObjectId, parameters) => {
  const url = `${PREFIX}questionManager/removeAnswerQuestionList/questionId/answerQuestionIds/tokensExpr/`
  const requestParameters = { ...parameters, questionId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addAnswer = (targetObjectId, parameters) => {
  const url = `${PREFIX}questionManager/addAnswer/questionId/title/comment/tokensExpr/`
  const questionId = targetObjectId
  const requestParameters = { ...parameters, questionId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAnswer = (targetObjectId, parameters) => {
  const url = `${PREFIX}questionManager/updateAnswerProperties/questionId/id/title/comment/tokensExpr/`
  const questionId = targetObjectId
  const requestParameters = { ...parameters, questionId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAnswerList = (targetObjectId, parameters) => {
  const url = `${PREFIX}questionManager/removeAnswerList/questionId/answerIds/tokensExpr/`
  const requestParameters = { ...parameters, questionId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addUserAnswer = (targetObjectId, parameters) => {
  const url = `${PREFIX}questionManager/addUserAnswer/questionId/topic/userSelect/examId/tokensExpr/`
  const questionId = targetObjectId
  const requestParameters = { ...parameters, questionId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateUserAnswer = (targetObjectId, parameters) => {
  const url = `${PREFIX}questionManager/updateUserAnswerProperties/questionId/id/topic/userSelect/tokensExpr/`
  const questionId = targetObjectId
  const requestParameters = { ...parameters, questionId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeUserAnswerList = (targetObjectId, parameters) => {
  const url = `${PREFIX}questionManager/removeUserAnswerList/questionId/userAnswerIds/tokensExpr/`
  const requestParameters = { ...parameters, questionId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}questionService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}questionService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}questionService/process/`,
    data,
  })
}

const QuestionService = { view,
  load,
  addAnswerQuestion,
  addAnswer,
  addUserAnswer,
  updateAnswerQuestion,
  updateAnswer,
  updateUserAnswer,
  removeAnswerQuestionList,
  removeAnswerList,
  removeUserAnswerList,
  requestCandidatePlatform,
  transferToAnotherPlatform, listFunctions, saveRequest, processRequest}
export default QuestionService

