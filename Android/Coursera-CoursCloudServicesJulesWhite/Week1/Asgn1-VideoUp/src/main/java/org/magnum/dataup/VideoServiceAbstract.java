package org.magnum.dataup;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.magnum.dataup.model.Video;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public abstract class VideoServiceAbstract {

	private static final AtomicLong currentId = new AtomicLong(0L);
	protected Map<Long, Video> videos = new HashMap<>();

	private void checkAndSetId(Video video) {
		if (video.getId() == 0) {
			video.setId(currentId.incrementAndGet());
		}
	}

	private void setDataUrl(Video video) {
		video.setDataUrl(getDataUrl(video.getId()));
	}

	private String getDataUrl(long videoId) {
		String url = getUrlBaseForLocalServer() + "/video/" + videoId + "/data";
		return url;
	}

	private String getUrlBaseForLocalServer() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String base = "http://" + request.getServerName()
				+ ((request.getServerPort() != 80) ? ":" + request.getServerPort() : "");
		return base;
	}

	protected Video save(Video video) {
		checkAndSetId(video);
		setDataUrl(video);
		videos.put(video.getId(), video);
		return video;
	}
}
