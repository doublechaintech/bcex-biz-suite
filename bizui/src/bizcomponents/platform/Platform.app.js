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
import styles from './Platform.app.less'
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




class PlatformBizApp extends React.PureComponent {
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
      return ['/platform/']
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
               <Link to={`/platform/${this.props.platform.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
  



  getChangeRequestTypeSearch = () => {
    const {ChangeRequestTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "变更请求类型",
      role: "changeRequestType",
      data: state._platform.changeRequestTypeList,
      metaInfo: state._platform.changeRequestTypeListMetaInfo,
      count: state._platform.changeRequestTypeCount,
      returnURL: `/platform/${state._platform.id}/dashboard`,
      currentPage: state._platform.changeRequestTypeCurrentPageNumber,
      searchFormParameters: state._platform.changeRequestTypeSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'changeRequestTypeList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChangeRequestTypeSearch)
  }
  getChangeRequestTypeCreateForm = () => {
   	const {ChangeRequestTypeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "changeRequestType",
      data: state._platform.changeRequestTypeList,
      metaInfo: state._platform.changeRequestTypeListMetaInfo,
      count: state._platform.changeRequestTypeCount,
      returnURL: `/platform/${state._platform.id}/list`,
      currentPage: state._platform.changeRequestTypeCurrentPageNumber,
      searchFormParameters: state._platform.changeRequestTypeSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'changeRequestTypeList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ChangeRequestTypeCreateForm)
  }
  
  getChangeRequestTypeUpdateForm = () => {
    const userContext = null
  	const {ChangeRequestTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "changeRequestType",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'changeRequestTypeList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChangeRequestTypeUpdateForm)
  }

  getChangeRequestSearch = () => {
    const {ChangeRequestSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "变更请求",
      role: "changeRequest",
      data: state._platform.changeRequestList,
      metaInfo: state._platform.changeRequestListMetaInfo,
      count: state._platform.changeRequestCount,
      returnURL: `/platform/${state._platform.id}/dashboard`,
      currentPage: state._platform.changeRequestCurrentPageNumber,
      searchFormParameters: state._platform.changeRequestSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'changeRequestList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChangeRequestSearch)
  }
  getChangeRequestCreateForm = () => {
   	const {ChangeRequestCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "changeRequest",
      data: state._platform.changeRequestList,
      metaInfo: state._platform.changeRequestListMetaInfo,
      count: state._platform.changeRequestCount,
      returnURL: `/platform/${state._platform.id}/list`,
      currentPage: state._platform.changeRequestCurrentPageNumber,
      searchFormParameters: state._platform.changeRequestSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'changeRequestList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ChangeRequestCreateForm)
  }
  
  getChangeRequestUpdateForm = () => {
    const userContext = null
  	const {ChangeRequestUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "changeRequest",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'changeRequestList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChangeRequestUpdateForm)
  }

  getExamStatusSearch = () => {
    const {ExamStatusSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "考试状态",
      role: "examStatus",
      data: state._platform.examStatusList,
      metaInfo: state._platform.examStatusListMetaInfo,
      count: state._platform.examStatusCount,
      returnURL: `/platform/${state._platform.id}/dashboard`,
      currentPage: state._platform.examStatusCurrentPageNumber,
      searchFormParameters: state._platform.examStatusSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'examStatusList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ExamStatusSearch)
  }
  getExamStatusCreateForm = () => {
   	const {ExamStatusCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "examStatus",
      data: state._platform.examStatusList,
      metaInfo: state._platform.examStatusListMetaInfo,
      count: state._platform.examStatusCount,
      returnURL: `/platform/${state._platform.id}/list`,
      currentPage: state._platform.examStatusCurrentPageNumber,
      searchFormParameters: state._platform.examStatusSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'examStatusList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ExamStatusCreateForm)
  }
  
  getExamStatusUpdateForm = () => {
    const userContext = null
  	const {ExamStatusUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "examStatus",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'examStatusList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ExamStatusUpdateForm)
  }

  getQuestionSearch = () => {
    const {QuestionSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "检查问题",
      role: "question",
      data: state._platform.questionList,
      metaInfo: state._platform.questionListMetaInfo,
      count: state._platform.questionCount,
      returnURL: `/platform/${state._platform.id}/dashboard`,
      currentPage: state._platform.questionCurrentPageNumber,
      searchFormParameters: state._platform.questionSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'questionList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(QuestionSearch)
  }
  getQuestionCreateForm = () => {
   	const {QuestionCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "question",
      data: state._platform.questionList,
      metaInfo: state._platform.questionListMetaInfo,
      count: state._platform.questionCount,
      returnURL: `/platform/${state._platform.id}/list`,
      currentPage: state._platform.questionCurrentPageNumber,
      searchFormParameters: state._platform.questionSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'questionList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(QuestionCreateForm)
  }
  
  getQuestionUpdateForm = () => {
    const userContext = null
  	const {QuestionUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "question",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'questionList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(QuestionUpdateForm)
  }

  getExamRankingSearch = () => {
    const {ExamRankingSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "考试排名",
      role: "examRanking",
      data: state._platform.examRankingList,
      metaInfo: state._platform.examRankingListMetaInfo,
      count: state._platform.examRankingCount,
      returnURL: `/platform/${state._platform.id}/dashboard`,
      currentPage: state._platform.examRankingCurrentPageNumber,
      searchFormParameters: state._platform.examRankingSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'examRankingList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ExamRankingSearch)
  }
  getExamRankingCreateForm = () => {
   	const {ExamRankingCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "examRanking",
      data: state._platform.examRankingList,
      metaInfo: state._platform.examRankingListMetaInfo,
      count: state._platform.examRankingCount,
      returnURL: `/platform/${state._platform.id}/list`,
      currentPage: state._platform.examRankingCurrentPageNumber,
      searchFormParameters: state._platform.examRankingSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'examRankingList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ExamRankingCreateForm)
  }
  
  getExamRankingUpdateForm = () => {
    const userContext = null
  	const {ExamRankingUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "examRanking",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'examRankingList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ExamRankingUpdateForm)
  }

  getWechatUserSearch = () => {
    const {WechatUserSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "微信用户",
      role: "wechatUser",
      data: state._platform.wechatUserList,
      metaInfo: state._platform.wechatUserListMetaInfo,
      count: state._platform.wechatUserCount,
      returnURL: `/platform/${state._platform.id}/dashboard`,
      currentPage: state._platform.wechatUserCurrentPageNumber,
      searchFormParameters: state._platform.wechatUserSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'wechatUserList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(WechatUserSearch)
  }
  getWechatUserCreateForm = () => {
   	const {WechatUserCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "wechatUser",
      data: state._platform.wechatUserList,
      metaInfo: state._platform.wechatUserListMetaInfo,
      count: state._platform.wechatUserCount,
      returnURL: `/platform/${state._platform.id}/list`,
      currentPage: state._platform.wechatUserCurrentPageNumber,
      searchFormParameters: state._platform.wechatUserSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'wechatUserList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(WechatUserCreateForm)
  }
  
  getWechatUserUpdateForm = () => {
    const userContext = null
  	const {WechatUserUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "wechatUser",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'wechatUserList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(WechatUserUpdateForm)
  }


  
  buildRouters = () =>{
  	const {PlatformDashboard} = GlobalComponents
  	const {PlatformPermission} = GlobalComponents
  	const {PlatformProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/platform/:id/dashboard", component: PlatformDashboard},
  	{path:"/platform/:id/profile", component: PlatformProfile},
  	{path:"/platform/:id/permission", component: PlatformPermission},
  	
  	
  	
  	{path:"/platform/:id/list/changeRequestTypeList", component: this.getChangeRequestTypeSearch()},
  	{path:"/platform/:id/list/changeRequestTypeCreateForm", component: this.getChangeRequestTypeCreateForm()},
  	{path:"/platform/:id/list/changeRequestTypeUpdateForm", component: this.getChangeRequestTypeUpdateForm()},
   	
  	{path:"/platform/:id/list/changeRequestList", component: this.getChangeRequestSearch()},
  	{path:"/platform/:id/list/changeRequestCreateForm", component: this.getChangeRequestCreateForm()},
  	{path:"/platform/:id/list/changeRequestUpdateForm", component: this.getChangeRequestUpdateForm()},
   	
  	{path:"/platform/:id/list/examStatusList", component: this.getExamStatusSearch()},
  	{path:"/platform/:id/list/examStatusCreateForm", component: this.getExamStatusCreateForm()},
  	{path:"/platform/:id/list/examStatusUpdateForm", component: this.getExamStatusUpdateForm()},
   	
  	{path:"/platform/:id/list/questionList", component: this.getQuestionSearch()},
  	{path:"/platform/:id/list/questionCreateForm", component: this.getQuestionCreateForm()},
  	{path:"/platform/:id/list/questionUpdateForm", component: this.getQuestionUpdateForm()},
   	
  	{path:"/platform/:id/list/examRankingList", component: this.getExamRankingSearch()},
  	{path:"/platform/:id/list/examRankingCreateForm", component: this.getExamRankingCreateForm()},
  	{path:"/platform/:id/list/examRankingUpdateForm", component: this.getExamRankingUpdateForm()},
   	
  	{path:"/platform/:id/list/wechatUserList", component: this.getWechatUserSearch()},
  	{path:"/platform/:id/list/wechatUserCreateForm", component: this.getWechatUserCreateForm()},
  	{path:"/platform/:id/list/wechatUserUpdateForm", component: this.getWechatUserUpdateForm()},
 	{path:"/platform/:id/ChangeRequestType/:code", component: GlobalComponents.ChangeRequestStepForm},
    	
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
            <Dropdown overlay= {this.getNavMenuItems(this.props.platform)}>
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
  platform: state._platform,
  ...state,
}))(PlatformBizApp)



