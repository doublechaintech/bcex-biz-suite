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


const menuData = {menuName:"变更请求", menuFor: "changeRequest",
  		subItems: [
  {name: 'registerationList', displayName:'在注册', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'startExamList', displayName:'开始考试', icon:'hourglass-start',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'answerQuestionList', displayName:'回答问题', icon:'question',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"变更请求", menuFor: "changeRequest",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  createTime: '创建时间',
  remoteIp: '远程Ip',
  requestType: '请求类型',
  platform: '平台',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'changeRequest') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.createTime, dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.remoteIp, debugtype: 'string_client_ip', dataIndex: 'remoteIp', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.requestType, dataIndex: 'requestType', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.platform, dataIndex: 'platform', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(changeRequest,targetComponent)=>{

  const userContext = null
  return (
    <div key={changeRequest.id}>
	
      <DescriptionList  key={changeRequest.id} size="small" col="4">
        <Description term="ID">{changeRequest.id}</Description> 
        <Description term="名称">{changeRequest.name}</Description> 
        <Description term="创建时间"><div>{ moment(changeRequest.createTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="远程Ip">{changeRequest.remoteIp}</Description> 
        <Description term={fieldLabels.requestType}><div>{changeRequest.requestType==null?appLocaleName(userContext,"NotAssigned"):`${changeRequest.requestType.displayName}(${changeRequest.requestType.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, requestTypeId, platformId} = formValuesToPack
	const requestType = {id: requestTypeId, version: 2^31}
	const platform = {id: platformId, version: 2^31}
	const data = {name, requestType, platform}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, requestType, platform} = objectToUnpack
	const requestTypeId = requestType ? requestType.id : null
	const platformId = platform ? platform.id : null
	const data = {name, requestTypeId, platformId}
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
const ChangeRequestBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default ChangeRequestBase



