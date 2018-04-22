package  com.xt.ptus.mt.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.ptus.base.impl.BaseServiceImpl;
import com.xt.ptus.mt.dao.MtGoodsValuationReplyDao;
import com.xt.ptus.mt.entity.MtGoodsValuationReply;
import com.xt.ptus.mt.service.MtGoodsValuationReplyService;


@Service
public class MtGoodsValuationReplyServiceImpl extends BaseServiceImpl<MtGoodsValuationReply> implements MtGoodsValuationReplyService{

	@Autowired 
	private MtGoodsValuationReplyDao replyDao;
	
	/**
	 * 管理员回复评论
	 */
	@Override
	public MtGoodsValuationReply valuationReply(int valuationId, int replier, String contents) {
	
		MtGoodsValuationReply goodsValuationReply = new MtGoodsValuationReply();
		List<MtGoodsValuationReply> replyList = replyDao.getReplyByValuationId(valuationId);//TODO
		String replyId = null;
		for(MtGoodsValuationReply reply : replyList){
			replyId = reply.getId();
		}
        if(replyId == null){
		goodsValuationReply.setValuationId(valuationId);
		goodsValuationReply.setReplier(replier);
		goodsValuationReply.setContents(contents);
		goodsValuationReply.setReplyTime(new Date());
		replyDao.save(goodsValuationReply);
		return goodsValuationReply;
        }else{
        	MtGoodsValuationReply goodsReply = replyDao.get(replyId, MtGoodsValuationReply.class);
        	goodsReply.setReplyTime(new Date());
        	goodsReply.setValuationId(valuationId);
        	goodsReply.setContents(contents);
        	goodsReply.setReplier(replier);
        	replyDao.update(goodsReply);
        return goodsReply;
        }
	}

}
