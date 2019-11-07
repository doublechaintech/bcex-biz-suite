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


const menuData = {menuName:"开始考试", menuFor: "startExam",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"开始考试", menuFor: "startExam",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  nickName: '昵称',
  changeRequest: '变更请求',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'startExam') , sorter: true },
  { title: fieldLabels.nickName, debugtype: 'string', dataIndex: 'nickName', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.changeRequest, dataIndex: 'changeRequest', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(startExam,targetComponent)=>{

  const userContext = null
  return (
    <div key={startExam.id}>
	
      <DescriptionList  key={startExam.id} size="small" col="4">
        <Description term="ID">{startExam.id}</Description> 
        <Description term="昵称">{startExam.nickName}</Description> 
        <Description term={fieldLabels.changeRequest}><div>{startExam.changeRequest==null?appLocaleName(userContext,"NotAssigned"):`${startExam.changeRequest.displayName}(${startExam.changeRequest.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {nickName, changeRequestId} = formValuesToPack
	const changeRequest = {id: changeRequestId, version: 2^31}
	const data = {nickName, changeRequest}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {nickName, changeRequest} = objectToUnpack
	const changeRequestId = changeRequest ? changeRequest.id : null
	const data = {nickName, changeRequestId}
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
const StartExamBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default StartExamBase



