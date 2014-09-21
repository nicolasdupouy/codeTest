package org.magnum.mobilecloud.video.service.constants;

import org.magnum.mobilecloud.video.client.VideoSvcApi;

public final class VideoServiceConstants {

	private VideoServiceConstants() {
	}

	public static final String VIDEO_ID_PATH = VideoSvcApi.VIDEO_SVC_PATH + "/{id}";
	public static final String VIDEO_ID_LIKE_PATH = VIDEO_ID_PATH + "/like";
	public static final String VIDEO_ID_UNLIKE_PATH = VIDEO_ID_PATH + "/unlike";
	public static final String VIDEO_ID_LIKEBY_PATH = VIDEO_ID_PATH + "/likedby";

	public static final int HTTP_RESPONSE_OK_200 = 200;
	public static final int HTTP_RESPONSE_ERROR_400 = 400;
	public static final int HTTP_RESPONSE_ERROR_404 = 404;
}
