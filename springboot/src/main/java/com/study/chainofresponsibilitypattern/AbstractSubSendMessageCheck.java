package com.study.chainofresponsibilitypattern;

/**
 * @author huangsenwei
 * @Description
 */
public abstract class AbstractSubSendMessageCheck {

    private AbstractSubSendMessageCheck nextCheck;

    /**
     * 校验类
     * @return 结果
     */
    abstract String checkImpl(String name);

    /**
     * 校验
     * @param subSendMessageCheckChain 校验链
     * @param name
     * @return
     */
    protected   String  doCheck(AbstractSubSendMessageCheck subSendMessageCheckChain, String name){
        String oneCheckResult = subSendMessageCheckChain.checkImpl(name);
        if ( oneCheckResult != null) {
            return oneCheckResult;
        }else if(  subSendMessageCheckChain.nextCheck != null){
            doCheck( subSendMessageCheckChain.nextCheck,name);
        }
        return null;
    }

    public void setNextCheck(AbstractSubSendMessageCheck nextCheck) {
        this.nextCheck = nextCheck;
    }
}
