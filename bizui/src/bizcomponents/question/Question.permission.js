

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Question.profile.less'
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
const internalSummaryOf = (question,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
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
	)
}


const renderPermissionSetting = question => {
  const {QuestionBase} = GlobalComponents
  return <PermissionSetting targetObject={question}  targetObjectMeta={QuestionBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class QuestionPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  question = this.props.question
    const { id,displayName, answerQuestionCount, answerCount, userAnswerCount } = question
    const  returnURL = `/question/${id}/dashboard`
    const cardsData = {cardsName:"检查问题",cardsFor: "question",cardsSource: question,displayName,returnURL,
  		subItems: [
    
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
  question: state._question,
}))(Form.create()(QuestionPermission))

