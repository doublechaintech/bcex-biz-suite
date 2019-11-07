
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}answerManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}answerManager/loadAnswer/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateQuestion = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}answerManager/requestCandidateQuestion/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherQuestion = (id, parameters) => {
  const url = `${PREFIX}answerManager/transferToAnotherQuestion/id/anotherQuestionId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}answerService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}answerService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}answerService/process/`,
    data,
  })
}

const AnswerService = { view,
  load,
  requestCandidateQuestion,
  transferToAnotherQuestion, listFunctions, saveRequest, processRequest}
export default AnswerService

