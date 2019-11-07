
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}platformManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}platformManager/loadPlatform/${targetObjectId}/${parametersExpr}/`,
  })
}







const addChangeRequestType = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addChangeRequestType/platformId/name/code/icon/displayOrder/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateChangeRequestType = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateChangeRequestTypeProperties/platformId/id/name/code/icon/displayOrder/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeChangeRequestTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeChangeRequestTypeList/platformId/changeRequestTypeIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addChangeRequest = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addChangeRequest/platformId/name/requestTypeId/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateChangeRequest = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateChangeRequestProperties/platformId/id/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeChangeRequestList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeChangeRequestList/platformId/changeRequestIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addExamStatus = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addExamStatus/platformId/name/code/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateExamStatus = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateExamStatusProperties/platformId/id/name/code/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeExamStatusList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeExamStatusList/platformId/examStatusIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addQuestion = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addQuestion/platformId/topic/level/optionA/optionB/optionC/optionD/optionE/rightAnswer/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateQuestion = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateQuestionProperties/platformId/id/topic/level/optionA/optionB/optionC/optionD/optionE/rightAnswer/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeQuestionList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeQuestionList/platformId/questionIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addExamRanking = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addExamRanking/platformId/name/avarta/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateExamRanking = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateExamRankingProperties/platformId/id/name/avarta/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeExamRankingList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeExamRankingList/platformId/examRankingIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addWechatUser = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addWechatUser/platformId/name/avarta/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateWechatUser = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateWechatUserProperties/platformId/id/name/avarta/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeWechatUserList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeWechatUserList/platformId/wechatUserIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}platformService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}platformService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}platformService/process/`,
    data,
  })
}

const PlatformService = { view,
  load,
  addChangeRequestType,
  addChangeRequest,
  addExamStatus,
  addQuestion,
  addExamRanking,
  addWechatUser,
  updateChangeRequestType,
  updateChangeRequest,
  updateExamStatus,
  updateQuestion,
  updateExamRanking,
  updateWechatUser,
  removeChangeRequestTypeList,
  removeChangeRequestList,
  removeExamStatusList,
  removeQuestionList,
  removeExamRankingList,
  removeWechatUserList, listFunctions, saveRequest, processRequest}
export default PlatformService

