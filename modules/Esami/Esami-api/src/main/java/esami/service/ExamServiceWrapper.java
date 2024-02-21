/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package esami.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExamService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExamService
 * @generated
 */
public class ExamServiceWrapper
	implements ExamService, ServiceWrapper<ExamService> {

	public ExamServiceWrapper() {
		this(null);
	}

	public ExamServiceWrapper(ExamService examService) {
		_examService = examService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _examService.getOSGiServiceIdentifier();
	}

	@Override
	public ExamService getWrappedService() {
		return _examService;
	}

	@Override
	public void setWrappedService(ExamService examService) {
		_examService = examService;
	}

	private ExamService _examService;

}