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
import styles from './WechatUser.app.less'
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




class WechatUserBizApp extends React.PureComponent {
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
      return ['/wechatUser/']
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
               <Link to={`/wechatUser/${this.props.wechatUser.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
  



  getAnswerQuestionSearch = () => {
    const {AnswerQuestionSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "回答问题",
      role: "answerQuestion",
      data: state._wechatUser.answerQuestionList,
      metaInfo: state._wechatUser.answerQuestionListMetaInfo,
      count: state._wechatUser.answerQuestionCount,
      returnURL: `/wechatUser/${state._wechatUser.id}/dashboard`,
      currentPage: state._wechatUser.answerQuestionCurrentPageNumber,
      searchFormParameters: state._wechatUser.answerQuestionSearchFormParameters,
      searchParameters: {...state._wechatUser.searchParameters},
      expandForm: state._wechatUser.expandForm,
      loading: state._wechatUser.loading,
      partialList: state._wechatUser.partialList,
      owner: { type: '_wechatUser', id: state._wechatUser.id, 
      referenceName: 'user', 
      listName: 'answerQuestionList', ref:state._wechatUser, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AnswerQuestionSearch)
  }
  getAnswerQuestionCreateForm = () => {
   	const {AnswerQuestionCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "answerQuestion",
      data: state._wechatUser.answerQuestionList,
      metaInfo: state._wechatUser.answerQuestionListMetaInfo,
      count: state._wechatUser.answerQuestionCount,
      returnURL: `/wechatUser/${state._wechatUser.id}/list`,
      currentPage: state._wechatUser.answerQuestionCurrentPageNumber,
      searchFormParameters: state._wechatUser.answerQuestionSearchFormParameters,
      loading: state._wechatUser.loading,
      owner: { type: '_wechatUser', id: state._wechatUser.id, referenceName: 'user', listName: 'answerQuestionList', ref:state._wechatUser, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(AnswerQuestionCreateForm)
  }
  
  getAnswerQuestionUpdateForm = () => {
    const userContext = null
  	const {AnswerQuestionUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._wechatUser.selectedRows,
      role: "answerQuestion",
      currentUpdateIndex: state._wechatUser.currentUpdateIndex,
      owner: { type: '_wechatUser', id: state._wechatUser.id, listName: 'answerQuestionList', ref:state._wechatUser, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AnswerQuestionUpdateForm)
  }

  getWechatLoginInfoSearch = () => {
    const {WechatLoginInfoSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "微信登录信息",
      role: "wechatLoginInfo",
      data: state._wechatUser.wechatLoginInfoList,
      metaInfo: state._wechatUser.wechatLoginInfoListMetaInfo,
      count: state._wechatUser.wechatLoginInfoCount,
      returnURL: `/wechatUser/${state._wechatUser.id}/dashboard`,
      currentPage: state._wechatUser.wechatLoginInfoCurrentPageNumber,
      searchFormParameters: state._wechatUser.wechatLoginInfoSearchFormParameters,
      searchParameters: {...state._wechatUser.searchParameters},
      expandForm: state._wechatUser.expandForm,
      loading: state._wechatUser.loading,
      partialList: state._wechatUser.partialList,
      owner: { type: '_wechatUser', id: state._wechatUser.id, 
      referenceName: 'wechatUser', 
      listName: 'wechatLoginInfoList', ref:state._wechatUser, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(WechatLoginInfoSearch)
  }
  getWechatLoginInfoCreateForm = () => {
   	const {WechatLoginInfoCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "wechatLoginInfo",
      data: state._wechatUser.wechatLoginInfoList,
      metaInfo: state._wechatUser.wechatLoginInfoListMetaInfo,
      count: state._wechatUser.wechatLoginInfoCount,
      returnURL: `/wechatUser/${state._wechatUser.id}/list`,
      currentPage: state._wechatUser.wechatLoginInfoCurrentPageNumber,
      searchFormParameters: state._wechatUser.wechatLoginInfoSearchFormParameters,
      loading: state._wechatUser.loading,
      owner: { type: '_wechatUser', id: state._wechatUser.id, referenceName: 'wechatUser', listName: 'wechatLoginInfoList', ref:state._wechatUser, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(WechatLoginInfoCreateForm)
  }
  
  getWechatLoginInfoUpdateForm = () => {
    const userContext = null
  	const {WechatLoginInfoUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._wechatUser.selectedRows,
      role: "wechatLoginInfo",
      currentUpdateIndex: state._wechatUser.currentUpdateIndex,
      owner: { type: '_wechatUser', id: state._wechatUser.id, listName: 'wechatLoginInfoList', ref:state._wechatUser, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(WechatLoginInfoUpdateForm)
  }

  getExamSearch = () => {
    const {ExamSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "考试",
      role: "exam",
      data: state._wechatUser.examList,
      metaInfo: state._wechatUser.examListMetaInfo,
      count: state._wechatUser.examCount,
      returnURL: `/wechatUser/${state._wechatUser.id}/dashboard`,
      currentPage: state._wechatUser.examCurrentPageNumber,
      searchFormParameters: state._wechatUser.examSearchFormParameters,
      searchParameters: {...state._wechatUser.searchParameters},
      expandForm: state._wechatUser.expandForm,
      loading: state._wechatUser.loading,
      partialList: state._wechatUser.partialList,
      owner: { type: '_wechatUser', id: state._wechatUser.id, 
      referenceName: 'user', 
      listName: 'examList', ref:state._wechatUser, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ExamSearch)
  }
  getExamCreateForm = () => {
   	const {ExamCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "exam",
      data: state._wechatUser.examList,
      metaInfo: state._wechatUser.examListMetaInfo,
      count: state._wechatUser.examCount,
      returnURL: `/wechatUser/${state._wechatUser.id}/list`,
      currentPage: state._wechatUser.examCurrentPageNumber,
      searchFormParameters: state._wechatUser.examSearchFormParameters,
      loading: state._wechatUser.loading,
      owner: { type: '_wechatUser', id: state._wechatUser.id, referenceName: 'user', listName: 'examList', ref:state._wechatUser, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ExamCreateForm)
  }
  
  getExamUpdateForm = () => {
    const userContext = null
  	const {ExamUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._wechatUser.selectedRows,
      role: "exam",
      currentUpdateIndex: state._wechatUser.currentUpdateIndex,
      owner: { type: '_wechatUser', id: state._wechatUser.id, listName: 'examList', ref:state._wechatUser, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ExamUpdateForm)
  }

  getFaultAnswerSearch = () => {
    const {FaultAnswerSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "错误的答案",
      role: "faultAnswer",
      data: state._wechatUser.faultAnswerList,
      metaInfo: state._wechatUser.faultAnswerListMetaInfo,
      count: state._wechatUser.faultAnswerCount,
      returnURL: `/wechatUser/${state._wechatUser.id}/dashboard`,
      currentPage: state._wechatUser.faultAnswerCurrentPageNumber,
      searchFormParameters: state._wechatUser.faultAnswerSearchFormParameters,
      searchParameters: {...state._wechatUser.searchParameters},
      expandForm: state._wechatUser.expandForm,
      loading: state._wechatUser.loading,
      partialList: state._wechatUser.partialList,
      owner: { type: '_wechatUser', id: state._wechatUser.id, 
      referenceName: 'user', 
      listName: 'faultAnswerList', ref:state._wechatUser, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(FaultAnswerSearch)
  }
  getFaultAnswerCreateForm = () => {
   	const {FaultAnswerCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "faultAnswer",
      data: state._wechatUser.faultAnswerList,
      metaInfo: state._wechatUser.faultAnswerListMetaInfo,
      count: state._wechatUser.faultAnswerCount,
      returnURL: `/wechatUser/${state._wechatUser.id}/list`,
      currentPage: state._wechatUser.faultAnswerCurrentPageNumber,
      searchFormParameters: state._wechatUser.faultAnswerSearchFormParameters,
      loading: state._wechatUser.loading,
      owner: { type: '_wechatUser', id: state._wechatUser.id, referenceName: 'user', listName: 'faultAnswerList', ref:state._wechatUser, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(FaultAnswerCreateForm)
  }
  
  getFaultAnswerUpdateForm = () => {
    const userContext = null
  	const {FaultAnswerUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._wechatUser.selectedRows,
      role: "faultAnswer",
      currentUpdateIndex: state._wechatUser.currentUpdateIndex,
      owner: { type: '_wechatUser', id: state._wechatUser.id, listName: 'faultAnswerList', ref:state._wechatUser, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(FaultAnswerUpdateForm)
  }


  
  buildRouters = () =>{
  	const {WechatUserDashboard} = GlobalComponents
  	const {WechatUserPermission} = GlobalComponents
  	const {WechatUserProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/wechatUser/:id/dashboard", component: WechatUserDashboard},
  	{path:"/wechatUser/:id/profile", component: WechatUserProfile},
  	{path:"/wechatUser/:id/permission", component: WechatUserPermission},
  	
  	
  	
  	{path:"/wechatUser/:id/list/answerQuestionList", component: this.getAnswerQuestionSearch()},
  	{path:"/wechatUser/:id/list/answerQuestionCreateForm", component: this.getAnswerQuestionCreateForm()},
  	{path:"/wechatUser/:id/list/answerQuestionUpdateForm", component: this.getAnswerQuestionUpdateForm()},
   	
  	{path:"/wechatUser/:id/list/wechatLoginInfoList", component: this.getWechatLoginInfoSearch()},
  	{path:"/wechatUser/:id/list/wechatLoginInfoCreateForm", component: this.getWechatLoginInfoCreateForm()},
  	{path:"/wechatUser/:id/list/wechatLoginInfoUpdateForm", component: this.getWechatLoginInfoUpdateForm()},
   	
  	{path:"/wechatUser/:id/list/examList", component: this.getExamSearch()},
  	{path:"/wechatUser/:id/list/examCreateForm", component: this.getExamCreateForm()},
  	{path:"/wechatUser/:id/list/examUpdateForm", component: this.getExamUpdateForm()},
   	
  	{path:"/wechatUser/:id/list/faultAnswerList", component: this.getFaultAnswerSearch()},
  	{path:"/wechatUser/:id/list/faultAnswerCreateForm", component: this.getFaultAnswerCreateForm()},
  	{path:"/wechatUser/:id/list/faultAnswerUpdateForm", component: this.getFaultAnswerUpdateForm()},
     	
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
            <Dropdown overlay= {this.getNavMenuItems(this.props.wechatUser)}>
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
  wechatUser: state._wechatUser,
  ...state,
}))(WechatUserBizApp)



