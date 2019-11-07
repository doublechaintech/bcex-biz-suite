
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}faultAnswerManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}faultAnswerManager/loadFaultAnswer/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateUser = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}faultAnswerManager/requestCandidateUser/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherUser = (id, parameters) => {
  const url = `${PREFIX}faultAnswerManager/transferToAnotherUser/id/anotherUserId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateExam = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}faultAnswerManager/requestCandidateExam/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherExam = (id, parameters) => {
  const url = `${PREFIX}faultAnswerManager/transferToAnotherExam/id/anotherExamId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}faultAnswerService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}faultAnswerService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}faultAnswerService/process/`,
    data,
  })
}

const FaultAnswerService = { view,
  load,
  requestCandidateUser,
  requestCandidateExam,
  transferToAnotherUser,
  transferToAnotherExam, listFunctions, saveRequest, processRequest}
export default FaultAnswerService

