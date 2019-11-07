
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}changeRequestTypeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}changeRequestTypeManager/loadChangeRequestType/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}changeRequestTypeManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  const url = `${PREFIX}changeRequestTypeManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addChangeRequest = (targetObjectId, parameters) => {
  const url = `${PREFIX}changeRequestTypeManager/addChangeRequest/changeRequestTypeId/name/platformId/tokensExpr/`
  const changeRequestTypeId = targetObjectId
  const requestParameters = { ...parameters, changeRequestTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateChangeRequest = (targetObjectId, parameters) => {
  const url = `${PREFIX}changeRequestTypeManager/updateChangeRequestProperties/changeRequestTypeId/id/name/tokensExpr/`
  const changeRequestTypeId = targetObjectId
  const requestParameters = { ...parameters, changeRequestTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeChangeRequestList = (targetObjectId, parameters) => {
  const url = `${PREFIX}changeRequestTypeManager/removeChangeRequestList/changeRequestTypeId/changeRequestIds/tokensExpr/`
  const requestParameters = { ...parameters, changeRequestTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}changeRequestTypeService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}changeRequestTypeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}changeRequestTypeService/process/`,
    data,
  })
}

const ChangeRequestTypeService = { view,
  load,
  addChangeRequest,
  updateChangeRequest,
  removeChangeRequestList,
  requestCandidatePlatform,
  transferToAnotherPlatform, listFunctions, saveRequest, processRequest}
export default ChangeRequestTypeService

