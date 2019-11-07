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


const menuData = {menuName:"回答", menuFor: "answer",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"回答", menuFor: "answer",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  title: '标题',
  comment: '评论',
  question: '检查问题',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'answer') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.comment, debugtype: 'string', dataIndex: 'comment', width: '18',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.question, dataIndex: 'question', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(answer,targetComponent)=>{

  const userContext = null
  return (
    <div key={answer.id}>
	
      <DescriptionList  key={answer.id} size="small" col="4">
        <Description term="ID">{answer.id}</Description> 
        <Description term="标题">{answer.title}</Description> 
        <Description term="评论">{answer.comment}</Description> 
        <Description term={fieldLabels.question}><div>{answer.question==null?appLocaleName(userContext,"NotAssigned"):`${answer.question.displayName}(${answer.question.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, comment, questionId} = formValuesToPack
	const question = {id: questionId, version: 2^31}
	const data = {title, comment, question}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, comment, question} = objectToUnpack
	const questionId = question ? question.id : null
	const data = {title, comment, questionId}
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
const AnswerBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default AnswerBase



