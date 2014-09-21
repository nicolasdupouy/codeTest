/*
 * 
 * Copyright 2014 Jules White
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package org.magnum.mobilecloud.video.service;

import java.security.Principal;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.magnum.mobilecloud.video.client.VideoSvcApi;
import org.magnum.mobilecloud.video.repository.Video;
import org.magnum.mobilecloud.video.repository.VideoRepository;
import org.magnum.mobilecloud.video.service.constants.VideoServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

@Controller
public class VideoService {

	@Autowired
	private VideoRepository videos;

	private Video searchVideoOrFail(
			long id,
			HttpServletResponse response) {
		Video video = videos.findOne(id);
		if (video == null
				|| video.getId() < 0) {
			failVideoFileNotFound(response);
		}
		return video;
	}

	private void failVideoFileNotFound(HttpServletResponse response) {
		response.setStatus(VideoServiceConstants.HTTP_RESPONSE_ERROR_404);
		throw new ResourceNotFoundException();
	}

	private void failProblemLikingVideo(HttpServletResponse response) {
		response.setStatus(VideoServiceConstants.HTTP_RESPONSE_ERROR_400);
	}

	@RequestMapping(value = VideoSvcApi.VIDEO_SVC_PATH, method = RequestMethod.GET)
	public @ResponseBody Collection<Video> getVideoList() {
		return Lists.newArrayList(videos.findAll());
	}

	@RequestMapping(value = VideoSvcApi.VIDEO_SVC_PATH + "/{id}", method = RequestMethod.GET)
	public @ResponseBody Video getVideoById(
			@PathVariable long id,
			HttpServletResponse response) {

		return searchVideoOrFail(id, response);
	}

	@RequestMapping(value = VideoSvcApi.VIDEO_SVC_PATH, method = RequestMethod.POST)
	public @ResponseBody Video addVideo(
			@RequestBody Video video) {
		return videos.save(video);
	}

	@RequestMapping(value = VideoServiceConstants.VIDEO_ID_LIKE_PATH, method = RequestMethod.POST)
	public void likeVideo(
			@PathVariable long id,
			Principal p,
			HttpServletResponse response) {

		Video video = searchVideoOrFail(id, response);
		if (!video.addLike(p.getName())) {
			failProblemLikingVideo(response);
		}
		videos.save(video);
	}

	@RequestMapping(value = VideoServiceConstants.VIDEO_ID_UNLIKE_PATH, method = RequestMethod.POST)
	public void unlikeVideo(
			@PathVariable long id,
			Principal p,
			HttpServletResponse response) {

		Video video = searchVideoOrFail(id, response);
		if (!video.suppressLike(p.getName())) {
			failProblemLikingVideo(response);
		}
		videos.save(video);
	}

	@RequestMapping(value = VideoServiceConstants.VIDEO_ID_LIKEBY_PATH, method = RequestMethod.GET)
	public @ResponseBody Collection<String> getUsersWhoLikedVideo(
			@PathVariable long id,
			Principal p,
			HttpServletResponse response) {
		Video video = searchVideoOrFail(id, response);
		return video.getUsersLiking();
	}

}
