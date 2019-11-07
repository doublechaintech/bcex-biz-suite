
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}examStatusManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}examStatusManager/loadExamStatus/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}examStatusManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  const url = `${PREFIX}examStatusManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addExam = (targetObjectId, parameters) => {
  const url = `${PREFIX}examStatusManager/addExam/examStatusId/name/userId/score/tokensExpr/`
  const examStatusId = targetObjectId
  const requestParameters = { ...parameters, examStatusId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateExam = (targetObjectId, parameters) => {
  const url = `${PREFIX}examStatusManager/updateExamProperties/examStatusId/id/name/score/tokensExpr/`
  const examStatusId = targetObjectId
  const requestParameters = { ...parameters, examStatusId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeExamList = (targetObjectId, parameters) => {
  const url = `${PREFIX}examStatusManager/removeExamList/examStatusId/examIds/tokensExpr/`
  const requestParameters = { ...parameters, examStatusId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}examStatusService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}examStatusService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}examStatusService/process/`,
    data,
  })
}

const ExamStatusService = { view,
  load,
  addExam,
  updateExam,
  removeExamList,
  requestCandidatePlatform,
  transferToAnotherPlatform, listFunctions, saveRequest, processRequest}
export default ExamStatusService

