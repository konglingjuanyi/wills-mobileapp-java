package com.tg.dao;

import java.util.List;

import com.tg.model.GuideEvent;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

@DAO(catalog = "tg")
public interface GuideEventDAO {
	
	@SQL("insert into guide_event values (:1.guideId,:1.userId,:1.eventId,:1.status,:1.satisfaction,:1.createTime,:1.eventType,:1.startTime,:1.endTime,:1.scenic)")
	public int insertGuideEvent(GuideEvent guideEvent);

	@SQL("update guide_event set status=:2 where event_id=:1 and guide_id=:3 and status=0")
	public int changeStatus(long eventId,int status,int guideId);
	
	@SQL("update guide_event set satisfaction=:2 ,status=3  where event_id=:1 and status=1")
	public int setSatisfaction(long eventId,int satisfaction,int guideId);
	
	@SQL("select * from guide_event where guide_id=:1 order by create_time limit :2,:3")
	public List<GuideEvent> getHistoricalGuideEvents(int guideId,int start,int count);
	
	@SQL("select * from guide_event where event_id=:2")
	public GuideEvent getOneHistoricalGuideEvent(int guideId,long eventId);
}
