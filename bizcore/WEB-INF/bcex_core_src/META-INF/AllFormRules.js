

export const PaymentOptionSelectionFormConfig = {
  "verifyCode": {
    "rules": [
      {
        "min": 6,
        "message": "验证码至少需要6个字"
      },
      {
        "max": 12,
        "message": "验证码最多可以12个字"
      }
    ],
    "label": "验证码",
    "placeholder": "请输入验证码",
    "maxLength": 12
  },
  "paymentOptions": {
    "rules": [
      {
        "message": "支付选项不能为空",
        "required": true
      },
      {
        "min": 1,
        "message": "支付选项至少为1"
      },
      {
        "max": 100,
        "message": "支付选项最大为100"
      }
    ],
    "label": "支付选项",
    "placeholder": "请输入支付选项"
  },
  "id": {
    "rules": [
      {
        "min": 5,
        "message": "ID至少需要5个字"
      },
      {
        "max": 64,
        "message": "ID最多可以64个字"
      }
    ],
    "label": "ID",
    "placeholder": "请输入ID",
    "maxLength": 64
  }
}













