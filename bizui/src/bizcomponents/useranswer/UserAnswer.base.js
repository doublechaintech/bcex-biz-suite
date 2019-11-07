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


const menuData = {menuName:"用户的答案", menuFor: "userAnswer",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"用户的答案", menuFor: "userAnswer",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  topic: '主题',
  userSelect: '用户选择',
  question: '检查问题',
  exam: '考试',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'userAnswer') , sorter: true },
  { title: fieldLabels.topic, debugtype: 'string', dataIndex: 'topic', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.userSelect, debugtype: 'string', dataIndex: 'userSelect', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.question, dataIndex: 'question', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.exam, dataIndex: 'exam', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(userAnswer,targetComponent)=>{

  const userContext = null
  return (
    <div key={userAnswer.id}>
	
      <DescriptionList  key={userAnswer.id} size="small" col="4">
        <Description term="ID">{userAnswer.id}</Description> 
        <Description term="主题">{userAnswer.topic}</Description> 
        <Description term="用户选择">{userAnswer.userSelect}</Description> 
        <Description term={fieldLabels.question}><div>{userAnswer.question==null?appLocaleName(userContext,"NotAssigned"):`${userAnswer.question.displayName}(${userAnswer.question.id})`}
        </div></Description>
        <Description term={fieldLabels.exam}><div>{userAnswer.exam==null?appLocaleName(userContext,"NotAssigned"):`${userAnswer.exam.displayName}(${userAnswer.exam.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {topic, userSelect, questionId, examId} = formValuesToPack
	const question = {id: questionId, version: 2^31}
	const exam = {id: examId, version: 2^31}
	const data = {topic, userSelect, question, exam}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {topic, userSelect, question, exam} = objectToUnpack
	const questionId = question ? question.id : null
	const examId = exam ? exam.id : null
	const data = {topic, userSelect, questionId, examId}
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
const UserAnswerBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default UserAnswerBase



