/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package esami.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchExamException extends NoSuchModelException {

	public NoSuchExamException() {
	}

	public NoSuchExamException(String msg) {
		super(msg);
	}

	public NoSuchExamException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchExamException(Throwable throwable) {
		super(throwable);
	}

}