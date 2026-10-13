package common

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ChromeClean {

	@Keyword
	def openChromeClean() {
		RunConfiguration.setWebDriverPreferencesProperty('args', [
			'--incognito',
			'--disable-features=PasswordLeakDetection'
		])

		RunConfiguration.setWebDriverPreferencesProperty('prefs', [
			'credentials_enable_service'              : false,
			'profile.password_manager_enabled'        : false,
			'profile.password_manager_leak_detection' : false
		])

		WebUI.openBrowser('')
	}
}