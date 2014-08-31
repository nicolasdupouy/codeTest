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
package org.magnum.dataup;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.magnum.dataup.model.Video;
import org.magnum.dataup.model.VideoStatus;
import org.magnum.dataup.model.VideoStatus.VideoState;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class VideoService extends VideoServiceAbstract {

	/**
	 * You will need to create one or more Spring controllers to fulfill the
	 * requirements of the assignment. If you use this file, please rename it
	 * to something other than "AnEmptyController"
	 * 
	 * 
		 ________  ________  ________  ________          ___       ___  ___  ________  ___  __       
		|\   ____\|\   __  \|\   __  \|\   ___ \        |\  \     |\  \|\  \|\   ____\|\  \|\  \     
		\ \  \___|\ \  \|\  \ \  \|\  \ \  \_|\ \       \ \  \    \ \  \\\  \ \  \___|\ \  \/  /|_   
		 \ \  \  __\ \  \\\  \ \  \\\  \ \  \ \\ \       \ \  \    \ \  \\\  \ \  \    \ \   ___  \  
		  \ \  \|\  \ \  \\\  \ \  \\\  \ \  \_\\ \       \ \  \____\ \  \\\  \ \  \____\ \  \\ \  \ 
		   \ \_______\ \_______\ \_______\ \_______\       \ \_______\ \_______\ \_______\ \__\\ \__\
		    \|_______|\|_______|\|_______|\|_______|        \|_______|\|_______|\|_______|\|__| \|__|
	                                                                                                                                                                                                                                                                    
	 * 
	 */

	public static final String DATA_PARAMETER = "data";
	public static final String ID_PARAMETER = "id";
	public static final String VIDEO_SERVICE_PATH = "/video";
	public static final String VIDEO_DATA_PATH = VIDEO_SERVICE_PATH + "/{id}/data";

	private static final int HTTP_RESPONSE_ERROR_VIDEO_FILE_NOT_FOUND = 404;

	private void setResponseErrorVideoFileNotFound(HttpServletResponse response) {
		response.setStatus(HTTP_RESPONSE_ERROR_VIDEO_FILE_NOT_FOUND);
	}

	@RequestMapping(value = VIDEO_SERVICE_PATH, method = RequestMethod.GET)
	public @ResponseBody Collection<Video> getVideoList() {
		return videos.values();
	}

	@RequestMapping(value = VIDEO_SERVICE_PATH, method = RequestMethod.POST)
	public @ResponseBody Video addVideo(@RequestBody Video video) {
		return save(video);
	}

	@RequestMapping(value = VIDEO_DATA_PATH, method = RequestMethod.GET)
	public HttpServletResponse getData(
			@PathVariable long id,
			HttpServletResponse response) throws IOException {

		Video video = videos.get(id);
		if (video == null || !VideoFileManager.get().hasVideoData(video)) {
			setResponseErrorVideoFileNotFound(response);
			throw new ResourceNotFoundException();
		}

		VideoFileManager.get().copyVideoData(video, response.getOutputStream());
		return response;
	}

	@RequestMapping(value = VIDEO_DATA_PATH, method = RequestMethod.POST)
	public @ResponseBody VideoStatus setVideoData(
			@PathVariable(ID_PARAMETER) long id,
			@RequestParam(DATA_PARAMETER) MultipartFile videoData,
			HttpServletResponse response) throws IOException {

		Video video = videos.get(id);
		if (video == null) {
			setResponseErrorVideoFileNotFound(response);
			throw new ResourceNotFoundException();
		}

		VideoFileManager.get().saveVideoData(video, videoData.getInputStream());
		return new VideoStatus(VideoState.READY);
	}
}
