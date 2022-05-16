/**
 * <p>Title: liteflow</p>
 * <p>Description: 轻量级的组件式流程框架</p>
 * @author Bryan.Zhang
 * @email weenyc31@163.com
 * @Date 2020/4/1
 */
package com.yomahub.liteflow.test.privateDelivery.cmp;

import com.yomahub.liteflow.annotation.LiteflowCmpDefine;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.annotation.LiteflowMethod;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.entity.data.Slot;
import com.yomahub.liteflow.enums.LiteFlowMethodEnum;

import java.util.HashSet;

@LiteflowComponent("a")
@LiteflowCmpDefine
public class ACmp{

	@LiteflowMethod(LiteFlowMethodEnum.PROCESS)
	public void process(NodeComponent bindCmp) {
		System.out.println("ACmp executed!");
		Slot slot = bindCmp.getSlot();
		slot.setData("testSet", new HashSet<>());

		for (int i = 0; i < 100; i++) {
			bindCmp.sendPrivateDeliveryData("b",i+1);
		}
	}
}

