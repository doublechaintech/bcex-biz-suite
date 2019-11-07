


import React from 'react'
import { connect } from 'dva';
import { Steps, Button, message,Card, Form ,Icon} from 'antd';

import GlobalComponents from '../../custcomponents';
import FooterToolbar from '../../components/FooterToolbar'
import {sessionObject} from '../../utils/utils'
import Result from '../../components/Result';
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import { Link, Route, Redirect} from 'dva/router'
import pathToRegexp from 'path-to-regexp';

import styles from './ChangeRequest.stepform.less'
const { Step } = Steps;



const completeForm = ()=>{


   return (
     <Form layout="horizontal" >
      <Result
        type="success"
        title="提交成功"
        description="请等待处理结果"
        style={{ marginTop: 48, marginBottom: 16 }}
    />
     
     
    </Form>
  );


}


const completeStep = ()=>{

  return {
    title: '成功',
    content: completeForm(),
  }

}
 

const buildSteps=(targetComponent)=>{

	const changeRequestStepOf = GlobalComponents.ChangeRequestBase.stepOf
	const registerationStepOf = GlobalComponents.RegisterationBase.stepOf
	const startExamStepOf = GlobalComponents.StartExamBase.stepOf
	const answerQuestionStepOf = GlobalComponents.AnswerQuestionBase.stepOf

	const ChangeRequestCreateFormBody = GlobalComponents.ChangeRequestCreateFormBody
	const RegisterationCreateFormBody = GlobalComponents.RegisterationCreateFormBody
	const StartExamCreateFormBody = GlobalComponents.StartExamCreateFormBody
	const AnswerQuestionCreateFormBody = GlobalComponents.AnswerQuestionCreateFormBody

  
  const steps = [

	changeRequestStepOf(targetComponent, '创建变更请求', <ChangeRequestCreateFormBody {...targetComponent.props} hideTitle />, "", 0),
	registerationStepOf(targetComponent, '创建在注册', <RegisterationCreateFormBody {...targetComponent.props} hideTitle />, "registerationList", 0),
	startExamStepOf(targetComponent, '创建开始考试', <StartExamCreateFormBody {...targetComponent.props} hideTitle />, "startExamList", 0),
	answerQuestionStepOf(targetComponent, '创建回答问题', <AnswerQuestionCreateFormBody {...targetComponent.props} hideTitle />, "answerQuestionList", 0),

    completeStep(),
  ];
  return steps;



}

const packValues=(wrapper,name,values,packFunction, index)=>{

  if(name===""){
    return {...wrapper,...packFunction(values)}
  }
  
  if(!wrapper[name]){
    wrapper[name] = []
  }
  const oldValue = wrapper[name][index]
  if(!oldValue){
    wrapper[name][index] = packFunction(values)
    return wrapper
  }
  const changed = true
  const {id,version} = oldValue;

  wrapper[name][index] ={... packFunction(values),id,version,changed}
  return wrapper


}


const unwrap = (value, step) => {
  if(!value){
    return {}
  }
  const {index, position,unpackFunction}=step
  if(position === ""){
    return unpackFunction(value)
  }

  const list = value[position]
  if(!list){
    return {}
  }
  const element = list[index]
  if(!element){
    return {}
  }

  return unpackFunction(element)



}





class ChangeRequestStepForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      current: 0,
      changeRequest:{},
    };
  }

  componentDidMount(){
    


  }

  render() {
    
    
    const steps=buildSteps(this)




    const { form, dispatch, submitting, role } = this.props
    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError, resetFields,setFieldsValue } = form
    const next=()=> {
      console.log("this?",this)
      
      
      validateFieldsAndScroll((error, values) => {
        if (error) {
          console.log('error', error,"values",values)
          return
        }

        const step = steps[this.state.current]

       
        const {position,packFunction,index} = step
        const {changeRequest} = this.state
        const targetValue = packValues(changeRequest,position,values,packFunction,index)

        console.log("targetValue", targetValue)
        
        const { ChangeRequestService}  = GlobalComponents
        const future  = ChangeRequestService.saveRequest(targetValue)
        future.then(result=>{
          

          console.log('success and values', step)
          console.log(result)
          sessionObject(`cr-`,result)
          resetFields()
    
          const updatedChangeRequest = result;
          const current = this.state.current + 1;
          this.setState({ current,changeRequest:updatedChangeRequest},()=>updateForm());


        })


      })


  
    }
    
    const updateForm=()=>{
      console.log('success and values formReq-----------------------------11', this.state.changeRequest)
      if(!this.state.changeRequest.id){
        return
      }
      const step = steps[this.state.current]
      const formReq = unwrap(this.state.changeRequest,step);

      console.log('success and values formReq-----------------------------', formReq)
      setFieldsValue(formReq)



    }
    const prev=()=> {

      
      const current = this.state.current - 1;
      this.setState({ current },()=>updateForm());
    }


   
    
    const urlContext=()=>{
      const locationPath = this.props.location.pathname
      const pattern = "/:ownerType/:id/ChangeRequestType/:code/:localeName"
      const keys=[]
      const regexp = pathToRegexp(pattern, keys)
      const result = regexp.exec(locationPath)
      const parameterMap = {}
      // const parameterArray = keys.map((item,index)=>({key:item.name,value: result[index+1]}))
      keys.map((item,index)=>{
        // console.log("->", item.name, result[index+1])
        parameterMap [item.name]=result[index+1]
        return {key:item.name,value: result[index+1]}
      })
      // console.log("parameterMap",parameterMap,"result", result,"keys",keys)
      
      return parameterMap


    }
    const renderTitle=()=>{
     

      const urlContextValues = urlContext()
      
      const displayName = urlContextValues.localeName


      const userContext=null
      const returnURL=`/${urlContextValues.ownerType}/${urlContextValues.id}/dashboard`

      const linkComp=returnURL?<Link to={returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
      return (<div>{linkComp}{`${displayName}`}</div>);
    }
   


    const { current } = this.state;
    return (
     <PageHeaderLayout title={renderTitle()}>
      <Card >
      <div >
        <Steps current={current}>
          {steps.map(item => (
            <Step key={item.title} title={item.title} />
          ))}
        </Steps>
        <div className={styles.stepsContent} style={{marginBottom:"24px"}} >{steps[current].content}</div>


        <FooterToolbar>

        <div className={styles.stepAction}>
          {current > 0 && (
            <Button style={{ marginLeft: 8 }} onClick={prev}>
              上一步
            </Button>
          )}
          {current < steps.length - 1 && (
            <Button type="primary" onClick={next}>
              下一步
            </Button>
          )}
          {current === steps.length - 1 && (
            <Button type="primary" onClick={() => message.success('Processing complete!')}>
              完成
            </Button>
          )}
          
        </div>

        </FooterToolbar> 

        </div>
      
      </Card>
       </PageHeaderLayout>
    );
  }
}





export default connect(state => ({
 
  ...state,
}))((Form.create()(ChangeRequestStepForm)))


