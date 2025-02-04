/**
 * <p>Title: liteflow</p>
 * <p>Description: 轻量级的组件式流程框架</p>
 * @author Bryan.Zhang
 * @email weenyc31@163.com
 * @Date 2020/4/1
 */
package com.yomahub.liteflow.test.event.cmp;

import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DefaultContext;
import org.noear.solon.annotation.Component;

@Component("a")
public class ACmp extends NodeComponent {

	@Override
	public void process() {
		DefaultContext context = this.getFirstContextBean();
		context.setData("test","");
		System.out.println("ACmp executed!");
	}

	@Override
	public void onSuccess() throws Exception {
		DefaultContext context = this.getFirstContextBean();
		String str = context.getData("test");
		str += this.getNodeId();
		context.setData("test", str);
	}
}
