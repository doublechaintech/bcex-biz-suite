
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}wechatLoginInfoManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}wechatLoginInfoManager/loadWechatLoginInfo/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateWechatUser = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}wechatLoginInfoManager/requestCandidateWechatUser/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherWechatUser = (id, parameters) => {
  const url = `${PREFIX}wechatLoginInfoManager/transferToAnotherWechatUser/id/anotherWechatUserId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}wechatLoginInfoService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}wechatLoginInfoService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}wechatLoginInfoService/process/`,
    data,
  })
}

const WechatLoginInfoService = { view,
  load,
  requestCandidateWechatUser,
  transferToAnotherWechatUser, listFunctions, saveRequest, processRequest}
export default WechatLoginInfoService

