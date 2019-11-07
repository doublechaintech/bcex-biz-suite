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


const menuData = {menuName:"错误的答案", menuFor: "faultAnswer",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"错误的答案", menuFor: "faultAnswer",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  topic: '主题',
  yourAnswer: '你的答案',
  rightAnswer: '正确的答案',
  createTime: '创建时间',
  user: '用户',
  exam: '考试',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'faultAnswer') , sorter: true },
  { title: fieldLabels.topic, debugtype: 'string', dataIndex: 'topic', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.yourAnswer, debugtype: 'string', dataIndex: 'yourAnswer', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.rightAnswer, debugtype: 'string', dataIndex: 'rightAnswer', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.createTime, dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.user, dataIndex: 'user', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.exam, dataIndex: 'exam', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(faultAnswer,targetComponent)=>{

  const userContext = null
  return (
    <div key={faultAnswer.id}>
	
      <DescriptionList  key={faultAnswer.id} size="small" col="4">
        <Description term="ID">{faultAnswer.id}</Description> 
        <Description term="主题">{faultAnswer.topic}</Description> 
        <Description term="你的答案">{faultAnswer.yourAnswer}</Description> 
        <Description term="正确的答案">{faultAnswer.rightAnswer}</Description> 
        <Description term="创建时间"><div>{ moment(faultAnswer.createTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term={fieldLabels.user}><div>{faultAnswer.user==null?appLocaleName(userContext,"NotAssigned"):`${faultAnswer.user.displayName}(${faultAnswer.user.id})`}
        </div></Description>
        <Description term={fieldLabels.exam}><div>{faultAnswer.exam==null?appLocaleName(userContext,"NotAssigned"):`${faultAnswer.exam.displayName}(${faultAnswer.exam.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {topic, yourAnswer, rightAnswer, userId, examId} = formValuesToPack
	const user = {id: userId, version: 2^31}
	const exam = {id: examId, version: 2^31}
	const data = {topic, yourAnswer, rightAnswer, user, exam}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {topic, yourAnswer, rightAnswer, user, exam} = objectToUnpack
	const userId = user ? user.id : null
	const examId = exam ? exam.id : null
	const data = {topic, yourAnswer, rightAnswer, userId, examId}
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
const FaultAnswerBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default FaultAnswerBase



