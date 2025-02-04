/**
 * <p>Title: liteflow</p>
 * <p>Description: 轻量级的组件式流程框架</p>
 * @author Bryan.Zhang
 * @email weenyc31@163.com
 * @Date 2020/4/1
 */
package com.yomahub.liteflow.test.iterator.cmp;

import com.yomahub.liteflow.annotation.LiteflowCmpDefine;
import com.yomahub.liteflow.annotation.LiteflowMethod;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.enums.LiteFlowMethodEnum;
import com.yomahub.liteflow.enums.NodeTypeEnum;
import com.yomahub.liteflow.slot.DefaultContext;
import org.springframework.stereotype.Component;

@Component("a")
@LiteflowCmpDefine(NodeTypeEnum.COMMON)
public class ACmp{

	@LiteflowMethod(LiteFlowMethodEnum.PROCESS)
	public void process(NodeComponent bindCmp) {
		String key = "test";
		DefaultContext context = bindCmp.getFirstContextBean();
		if (!context.hasData(key)){
			context.setData(key, bindCmp.getCurrLoopObj());
		}else{
			String str = context.getData(key);
			str += bindCmp.getCurrLoopObj();
			context.setData(key, str);
		}
	}
}
