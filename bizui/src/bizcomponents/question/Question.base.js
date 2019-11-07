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


const menuData = {menuName:"检查问题", menuFor: "question",
  		subItems: [
  {name: 'answerQuestionList', displayName:'回答问题', icon:'question',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'answerList', displayName:'回答', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'userAnswerList', displayName:'用户的答案', icon:'user',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"检查问题", menuFor: "question",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  topic: '主题',
  level: '水平',
  optionA: 'A选项',
  optionB: 'B选项',
  optionC: 'C选项',
  optionD: 'D选项',
  optionE: 'E选项',
  rightAnswer: '正确的答案',
  platform: '平台',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'question') , sorter: true },
  { title: fieldLabels.topic, debugtype: 'string', dataIndex: 'topic', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.level, debugtype: 'string', dataIndex: 'level', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.optionA, debugtype: 'string', dataIndex: 'optionA', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.optionB, debugtype: 'string', dataIndex: 'optionB', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.optionC, debugtype: 'string', dataIndex: 'optionC', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.optionD, debugtype: 'string', dataIndex: 'optionD', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.optionE, debugtype: 'string', dataIndex: 'optionE', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.rightAnswer, debugtype: 'string', dataIndex: 'rightAnswer', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.platform, dataIndex: 'platform', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(question,targetComponent)=>{

  const userContext = null
  return (
    <div key={question.id}>
	
      <DescriptionList  key={question.id} size="small" col="4">
        <Description term="ID">{question.id}</Description> 
        <Description term="主题">{question.topic}</Description> 
        <Description term="水平">{question.level}</Description> 
        <Description term="A选项">{question.optionA}</Description> 
        <Description term="B选项">{question.optionB}</Description> 
        <Description term="C选项">{question.optionC}</Description> 
        <Description term="D选项">{question.optionD}</Description> 
        <Description term="E选项">{question.optionE}</Description> 
        <Description term="正确的答案">{question.rightAnswer}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {topic, level, optionA, optionB, optionC, optionD, optionE, rightAnswer, platformId} = formValuesToPack
	const platform = {id: platformId, version: 2^31}
	const data = {topic, level, optionA, optionB, optionC, optionD, optionE, rightAnswer, platform}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {topic, level, optionA, optionB, optionC, optionD, optionE, rightAnswer, platform} = objectToUnpack
	const platformId = platform ? platform.id : null
	const data = {topic, level, optionA, optionB, optionC, optionD, optionE, rightAnswer, platformId}
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
const QuestionBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default QuestionBase



