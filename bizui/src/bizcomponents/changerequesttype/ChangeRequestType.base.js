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


const menuData = {menuName:"变更请求类型", menuFor: "changeRequestType",
  		subItems: [
  {name: 'changeRequestList', displayName:'变更请求', icon:'exchange-alt',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"变更请求类型", menuFor: "changeRequestType",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  code: '代码',
  icon: '图标',
  displayOrder: '显示顺序',
  platform: '平台',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'changeRequestType') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.icon, debugtype: 'string', dataIndex: 'icon', width: '16',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.displayOrder, debugtype: 'int', dataIndex: 'displayOrder', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.platform, dataIndex: 'platform', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(changeRequestType,targetComponent)=>{

  const userContext = null
  return (
    <div key={changeRequestType.id}>
	
      <DescriptionList  key={changeRequestType.id} size="small" col="4">
        <Description term="ID">{changeRequestType.id}</Description> 
        <Description term="名称">{changeRequestType.name}</Description> 
        <Description term="代码">{changeRequestType.code}</Description> 
        <Description term="图标">{changeRequestType.icon}</Description> 
        <Description term="显示顺序"><div style={{"color":"red"}}>{changeRequestType.displayOrder}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, code, icon, displayOrder, platformId} = formValuesToPack
	const platform = {id: platformId, version: 2^31}
	const data = {name, code, icon, displayOrder, platform}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, code, icon, displayOrder, platform} = objectToUnpack
	const platformId = platform ? platform.id : null
	const data = {name, code, icon, displayOrder, platformId}
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
const ChangeRequestTypeBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default ChangeRequestTypeBase



