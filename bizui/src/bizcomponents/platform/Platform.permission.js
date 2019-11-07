

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Platform.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (platform,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{platform.id}</Description> 
<Description term="名称">{platform.name}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = platform => {
  const {PlatformBase} = GlobalComponents
  return <PermissionSetting targetObject={platform}  targetObjectMeta={PlatformBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class PlatformPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  platform = this.props.platform
    const { id,displayName, changeRequestTypeCount, changeRequestCount, examStatusCount, questionCount, examRankingCount, wechatUserCount } = platform
    const  returnURL = `/platform/${id}/dashboard`
    const cardsData = {cardsName:"平台",cardsFor: "platform",cardsSource: platform,displayName,returnURL,
  		subItems: [
{name: 'changeRequestTypeList', displayName:'变更请求类型',type:'changeRequestType',count:changeRequestTypeCount,addFunction: false, role: 'changeRequestType', data: platform.changeRequestTypeList},
{name: 'examStatusList', displayName:'考试状态',type:'examStatus',count:examStatusCount,addFunction: false, role: 'examStatus', data: platform.examStatusList},
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  platform: state._platform,
}))(Form.create()(PlatformPermission))

