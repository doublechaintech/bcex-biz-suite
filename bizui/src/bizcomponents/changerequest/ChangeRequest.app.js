import React from 'react'
import PropTypes from 'prop-types'
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,Row, Col,
  Input,Button
} from 'antd'
import TopMenu from '../../launcher/TopMenu'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './ChangeRequest.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'
import BizAppTool from '../../common/BizApp.tool'

const { Header, Sider, Content } = Layout
const { SubMenu } = Menu
const {
  defaultFilteredNoGroupMenuItems,
  defaultFilteredMenuItemsGroup,
  defaultRenderMenuItem,

} = BizAppTool


const filteredNoGroupMenuItems = defaultFilteredNoGroupMenuItems
const filteredMenuItemsGroup = defaultFilteredMenuItemsGroup
const renderMenuItem=defaultRenderMenuItem



const userBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 6,
  xl: 6,
  
};


const searchBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 12,
  xl: 12,
  
};


const naviBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 6,
  xl: 6,
  
};


const query = {
  'screen-xs': {
    maxWidth: 575,
  },
  'screen-sm': {
    minWidth: 576,
    maxWidth: 767,
  },
  'screen-md': {
    minWidth: 768,
    maxWidth: 991,
  },
  'screen-lg': {
    minWidth: 992,
    maxWidth: 1199,
  },
  'screen-xl': {
    minWidth: 1200,
  },
}




class ChangeRequestBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
     this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    }
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout)
  }
  onCollapse = (collapsed) => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    })
  }

  getDefaultCollapsedSubMenus = (props) => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)]
    currentMenuSelectedKeys.splice(-1, 1)
    if (currentMenuSelectedKeys.length === 0) {
      return ['/changeRequest/']
    }
    return currentMenuSelectedKeys
  }
  getCurrentMenuSelectedKeys = (props) => {
    const { location: { pathname } } = props || this.props
    const keys = pathname.split('/').slice(1)
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key]
    }
    return keys
  }
  
  getNavMenuItems = (targetObject) => {
  

    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
	const {objectId}=targetApp;
  	const userContext = null
    return (
	  <Menu
        theme="dark"
        mode="inline"
        
        onOpenChange={this.handleOpenChange}
        defaultOpenKeys={['firstOne']}
        style={{ width: '256px' }}
       >
           

             <Menu.Item key="dashboard">
               <Link to={`/changeRequest/${this.props.changeRequest.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}  
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu key={`vg${index}`} title={<span><Icon type="folder" style={{marginRight:"20px"}} /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
      {groupedMenuItem.subItems.map((item)=>(renderMenuItem(item)))}  
    </SubMenu>

        )}
        )}

       		
        
           </Menu>
    )
  }
  



  getRegistrationSearch = () => {
    const {RegistrationSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "登记",
      role: "registration",
      data: state._changeRequest.registrationList,
      metaInfo: state._changeRequest.registrationListMetaInfo,
      count: state._changeRequest.registrationCount,
      returnURL: `/changeRequest/${state._changeRequest.id}/dashboard`,
      currentPage: state._changeRequest.registrationCurrentPageNumber,
      searchFormParameters: state._changeRequest.registrationSearchFormParameters,
      searchParameters: {...state._changeRequest.searchParameters},
      expandForm: state._changeRequest.expandForm,
      loading: state._changeRequest.loading,
      partialList: state._changeRequest.partialList,
      owner: { type: '_changeRequest', id: state._changeRequest.id, 
      referenceName: 'changeRequest', 
      listName: 'registrationList', ref:state._changeRequest, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RegistrationSearch)
  }
  getRegistrationCreateForm = () => {
   	const {RegistrationCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "registration",
      data: state._changeRequest.registrationList,
      metaInfo: state._changeRequest.registrationListMetaInfo,
      count: state._changeRequest.registrationCount,
      returnURL: `/changeRequest/${state._changeRequest.id}/list`,
      currentPage: state._changeRequest.registrationCurrentPageNumber,
      searchFormParameters: state._changeRequest.registrationSearchFormParameters,
      loading: state._changeRequest.loading,
      owner: { type: '_changeRequest', id: state._changeRequest.id, referenceName: 'changeRequest', listName: 'registrationList', ref:state._changeRequest, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RegistrationCreateForm)
  }
  
  getRegistrationUpdateForm = () => {
    const userContext = null
  	const {RegistrationUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._changeRequest.selectedRows,
      role: "registration",
      currentUpdateIndex: state._changeRequest.currentUpdateIndex,
      owner: { type: '_changeRequest', id: state._changeRequest.id, listName: 'registrationList', ref:state._changeRequest, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RegistrationUpdateForm)
  }

  getStartExamSearch = () => {
    const {StartExamSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "开始考试",
      role: "startExam",
      data: state._changeRequest.startExamList,
      metaInfo: state._changeRequest.startExamListMetaInfo,
      count: state._changeRequest.startExamCount,
      returnURL: `/changeRequest/${state._changeRequest.id}/dashboard`,
      currentPage: state._changeRequest.startExamCurrentPageNumber,
      searchFormParameters: state._changeRequest.startExamSearchFormParameters,
      searchParameters: {...state._changeRequest.searchParameters},
      expandForm: state._changeRequest.expandForm,
      loading: state._changeRequest.loading,
      partialList: state._changeRequest.partialList,
      owner: { type: '_changeRequest', id: state._changeRequest.id, 
      referenceName: 'changeRequest', 
      listName: 'startExamList', ref:state._changeRequest, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(StartExamSearch)
  }
  getStartExamCreateForm = () => {
   	const {StartExamCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "startExam",
      data: state._changeRequest.startExamList,
      metaInfo: state._changeRequest.startExamListMetaInfo,
      count: state._changeRequest.startExamCount,
      returnURL: `/changeRequest/${state._changeRequest.id}/list`,
      currentPage: state._changeRequest.startExamCurrentPageNumber,
      searchFormParameters: state._changeRequest.startExamSearchFormParameters,
      loading: state._changeRequest.loading,
      owner: { type: '_changeRequest', id: state._changeRequest.id, referenceName: 'changeRequest', listName: 'startExamList', ref:state._changeRequest, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(StartExamCreateForm)
  }
  
  getStartExamUpdateForm = () => {
    const userContext = null
  	const {StartExamUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._changeRequest.selectedRows,
      role: "startExam",
      currentUpdateIndex: state._changeRequest.currentUpdateIndex,
      owner: { type: '_changeRequest', id: state._changeRequest.id, listName: 'startExamList', ref:state._changeRequest, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(StartExamUpdateForm)
  }

  getAnswerQuestionSearch = () => {
    const {AnswerQuestionSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "回答问题",
      role: "answerQuestion",
      data: state._changeRequest.answerQuestionList,
      metaInfo: state._changeRequest.answerQuestionListMetaInfo,
      count: state._changeRequest.answerQuestionCount,
      returnURL: `/changeRequest/${state._changeRequest.id}/dashboard`,
      currentPage: state._changeRequest.answerQuestionCurrentPageNumber,
      searchFormParameters: state._changeRequest.answerQuestionSearchFormParameters,
      searchParameters: {...state._changeRequest.searchParameters},
      expandForm: state._changeRequest.expandForm,
      loading: state._changeRequest.loading,
      partialList: state._changeRequest.partialList,
      owner: { type: '_changeRequest', id: state._changeRequest.id, 
      referenceName: 'changeRequest', 
      listName: 'answerQuestionList', ref:state._changeRequest, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AnswerQuestionSearch)
  }
  getAnswerQuestionCreateForm = () => {
   	const {AnswerQuestionCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "answerQuestion",
      data: state._changeRequest.answerQuestionList,
      metaInfo: state._changeRequest.answerQuestionListMetaInfo,
      count: state._changeRequest.answerQuestionCount,
      returnURL: `/changeRequest/${state._changeRequest.id}/list`,
      currentPage: state._changeRequest.answerQuestionCurrentPageNumber,
      searchFormParameters: state._changeRequest.answerQuestionSearchFormParameters,
      loading: state._changeRequest.loading,
      owner: { type: '_changeRequest', id: state._changeRequest.id, referenceName: 'changeRequest', listName: 'answerQuestionList', ref:state._changeRequest, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(AnswerQuestionCreateForm)
  }
  
  getAnswerQuestionUpdateForm = () => {
    const userContext = null
  	const {AnswerQuestionUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._changeRequest.selectedRows,
      role: "answerQuestion",
      currentUpdateIndex: state._changeRequest.currentUpdateIndex,
      owner: { type: '_changeRequest', id: state._changeRequest.id, listName: 'answerQuestionList', ref:state._changeRequest, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AnswerQuestionUpdateForm)
  }


  
  buildRouters = () =>{
  	const {ChangeRequestDashboard} = GlobalComponents
  	const {ChangeRequestPermission} = GlobalComponents
  	const {ChangeRequestProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/changeRequest/:id/dashboard", component: ChangeRequestDashboard},
  	{path:"/changeRequest/:id/profile", component: ChangeRequestProfile},
  	{path:"/changeRequest/:id/permission", component: ChangeRequestPermission},
  	
  	
  	
  	{path:"/changeRequest/:id/list/registrationList", component: this.getRegistrationSearch()},
  	{path:"/changeRequest/:id/list/registrationCreateForm", component: this.getRegistrationCreateForm()},
  	{path:"/changeRequest/:id/list/registrationUpdateForm", component: this.getRegistrationUpdateForm()},
   	
  	{path:"/changeRequest/:id/list/startExamList", component: this.getStartExamSearch()},
  	{path:"/changeRequest/:id/list/startExamCreateForm", component: this.getStartExamCreateForm()},
  	{path:"/changeRequest/:id/list/startExamUpdateForm", component: this.getStartExamUpdateForm()},
   	
  	{path:"/changeRequest/:id/list/answerQuestionList", component: this.getAnswerQuestionSearch()},
  	{path:"/changeRequest/:id/list/answerQuestionCreateForm", component: this.getAnswerQuestionCreateForm()},
  	{path:"/changeRequest/:id/list/answerQuestionUpdateForm", component: this.getAnswerQuestionUpdateForm()},
     	
  	]
  	
  	const {extraRoutesFunc} = this.props;
  	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
  	const finalRoutes = routers.concat(extraRoutes)
    
  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}    
  	  	</Switch>)
  	
  
  }
 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '链问链答考试中台'
    return title
  }
 
  handleOpenChange = (openKeys) => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1)
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    })
  }
   toggle = () => {
     const { collapsed } = this.props
     this.props.dispatch({
       type: 'global/changeLayoutCollapsed',
       payload: !collapsed,
     })
   }
    logout = () => {
   
    console.log("log out called")
    this.props.dispatch({ type: 'launcher/signOut' })
  }
   render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     const { collapsed } = this.props
     
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
     const userContext = null
     const renderBreadcrumbText=(value)=>{
     	if(value==null){
     		return "..."
     	}
     	if(value.length < 10){
     		return value
     	}
     
     	return value.substring(0,10)+"..."
     	
     	
     }
     const menuProps = collapsed ? {} : {
       openKeys: this.state.openKeys,
     }
     const renderBreadcrumbMenuItem=(breadcrumbMenuItem)=>{

      return (
      <Menu.Item key={breadcrumbMenuItem.link}>
      <Link key={breadcrumbMenuItem.link} to={`${breadcrumbMenuItem.link}`} className={styles.breadcrumbLink}>
        <Icon type="heart" style={{marginRight:"10px",color:"red"}} />
        {renderBreadcrumbText(breadcrumbMenuItem.name)}
      </Link></Menu.Item>)

     }
     const breadcrumbMenu=()=>{
      const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
      return ( <Menu mode="vertical"> 
      {currentBreadcrumb.map(item => renderBreadcrumbMenuItem(item))}
      </Menu>)
  

     }
     const { Search } = Input;
     const layout = (
     <Layout>
 <Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>
          
        <Row type="flex" justify="start" align="bottom">
        
        <Col {...naviBarResponsiveStyle} >
            <Dropdown overlay= {this.getNavMenuItems(this.props.changeRequest)}>
              <a  className={styles.menuLink}>
                <Icon type="unordered-list" style={{fontSize:"20px", marginRight:"10px"}}/> 菜单
              </a>
            </Dropdown>            
            <Dropdown overlay={breadcrumbMenu()}>
              <a  className={styles.menuLink}>
                <Icon type="down" style={{fontSize:"20px", marginRight:"10px"}}/> 快速转到
              </a>
            </Dropdown>
        </Col>
        <Col  className={styles.searchBox} {...searchBarResponsiveStyle}  > 
          
          <Search size="default" placeholder="请输入搜索条件, 查找功能，数据和词汇解释,暂未实现" enterButton 
            style={{ marginLeft:"10px",marginTop:"7px",width:"100%"}} />
          </Col>
          <Col  {...userBarResponsiveStyle}  > 
            <Dropdown overlay= { <TopMenu {...this.props} />} className={styles.right}>
                <a  className={styles.menuLink}>
                  <Icon type="user" style={{fontSize:"20px",marginRight:"10px"}}/> 账户
                </a>
            </Dropdown>
            
           </Col>  
         
         </Row>
        </Header>
       <Layout style={{  marginTop: 44 }}>
       
         
         <Layout>
         
            
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
           
           {this.buildRouters()}
 
             
             
           </Content>
          </Layout>
        </Layout>
      </Layout>
     )
     return (
       <DocumentTitle title={this.getPageTitle()}>
         <ContainerQuery query={query}>
           {params => <div className={classNames(params)}>{layout}</div>}
         </ContainerQuery>
       </DocumentTitle>
     )
   }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  changeRequest: state._changeRequest,
  ...state,
}))(ChangeRequestBizApp)



