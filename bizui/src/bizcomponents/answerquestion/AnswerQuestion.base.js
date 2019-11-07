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


const menuData = {menuName:"回答问题", menuFor: "answerQuestion",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"回答问题", menuFor: "answerQuestion",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  nickName: '昵称',
  user: '用户',
  question: '检查问题',
  answer: '回答',
  changeRequest: '变更请求',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'answerQuestion') , sorter: true },
  { title: fieldLabels.nickName, debugtype: 'string', dataIndex: 'nickName', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.user, dataIndex: 'user', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.question, dataIndex: 'question', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.answer, debugtype: 'string', dataIndex: 'answer', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.changeRequest, dataIndex: 'changeRequest', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(answerQuestion,targetComponent)=>{

  const userContext = null
  return (
    <div key={answerQuestion.id}>
	
      <DescriptionList  key={answerQuestion.id} size="small" col="4">
        <Description term="ID">{answerQuestion.id}</Description> 
        <Description term="昵称">{answerQuestion.nickName}</Description> 
        <Description term={fieldLabels.user}><div>{answerQuestion.user==null?appLocaleName(userContext,"NotAssigned"):`${answerQuestion.user.displayName}(${answerQuestion.user.id})`}
        </div></Description>
        <Description term={fieldLabels.question}><div>{answerQuestion.question==null?appLocaleName(userContext,"NotAssigned"):`${answerQuestion.question.displayName}(${answerQuestion.question.id})`}
        </div></Description>
        <Description term="回答">{answerQuestion.answer}</Description> 
        <Description term={fieldLabels.changeRequest}><div>{answerQuestion.changeRequest==null?appLocaleName(userContext,"NotAssigned"):`${answerQuestion.changeRequest.displayName}(${answerQuestion.changeRequest.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {nickName, answer, userId, questionId, changeRequestId} = formValuesToPack
	const user = {id: userId, version: 2^31}
	const question = {id: questionId, version: 2^31}
	const changeRequest = {id: changeRequestId, version: 2^31}
	const data = {nickName, answer, user, question, changeRequest}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {nickName, answer, user, question, changeRequest} = objectToUnpack
	const userId = user ? user.id : null
	const questionId = question ? question.id : null
	const changeRequestId = changeRequest ? changeRequest.id : null
	const data = {nickName, answer, userId, questionId, changeRequestId}
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
const AnswerQuestionBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default AnswerQuestionBase



