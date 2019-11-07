import React from 'react'
import { Icon,Divider } from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"微信登录信息", menuFor: "wechatLoginInfo",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"微信登录信息", menuFor: "wechatLoginInfo",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  wechatUser: '微信用户',
  appId: '应用程序Id',
  openId: '开放Id',
  sessionKey: '会话密钥',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'wechatLoginInfo') , sorter: true },
  { title: fieldLabels.wechatUser, dataIndex: 'wechatUser', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.appId, debugtype: 'string', dataIndex: 'appId', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.openId, debugtype: 'string', dataIndex: 'openId', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.sessionKey, debugtype: 'string', dataIndex: 'sessionKey', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(wechatLoginInfo,targetComponent)=>{

  const userContext = null
  return (
    <div key={wechatLoginInfo.id}>
	
      <DescriptionList  key={wechatLoginInfo.id} size="small" col="4">
        <Description term="ID">{wechatLoginInfo.id}</Description> 
        <Description term={fieldLabels.wechatUser}><div>{wechatLoginInfo.wechatUser==null?appLocaleName(userContext,"NotAssigned"):`${wechatLoginInfo.wechatUser.displayName}(${wechatLoginInfo.wechatUser.id})`}
        </div></Description>
        <Description term="应用程序Id">{wechatLoginInfo.appId}</Description> 
        <Description term="开放Id">{wechatLoginInfo.openId}</Description> 
        <Description term="会话密钥">{wechatLoginInfo.sessionKey}</Description> 
        <Description term="最后更新时间"><div>{ moment(wechatLoginInfo.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {appId, openId, sessionKey, wechatUserId} = formValuesToPack
	const wechatUser = {id: wechatUserId, version: 2^31}
	const data = {appId, openId, sessionKey, wechatUser}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {appId, openId, sessionKey, wechatUser} = objectToUnpack
	const wechatUserId = wechatUser ? wechatUser.id : null
	const data = {appId, openId, sessionKey, wechatUserId}
	return data
}
const stepOf=(targetComponent, title, content, position, index)=>{
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
      }
}
const WechatLoginInfoBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default WechatLoginInfoBase



