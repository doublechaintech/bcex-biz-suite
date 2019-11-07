
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}userAnswerManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}userAnswerManager/loadUserAnswer/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateQuestion = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}userAnswerManager/requestCandidateQuestion/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherQuestion = (id, parameters) => {
  const url = `${PREFIX}userAnswerManager/transferToAnotherQuestion/id/anotherQuestionId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateExam = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}userAnswerManager/requestCandidateExam/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherExam = (id, parameters) => {
  const url = `${PREFIX}userAnswerManager/transferToAnotherExam/id/anotherExamId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}userAnswerService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}userAnswerService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}userAnswerService/process/`,
    data,
  })
}

const UserAnswerService = { view,
  load,
  requestCandidateQuestion,
  requestCandidateExam,
  transferToAnotherQuestion,
  transferToAnotherExam, listFunctions, saveRequest, processRequest}
export default UserAnswerService

