import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { provideHttpClient } from '@angular/common/http';

bootstrapApplication(App, {
  ...appConfig, // ✅ Spread your app-level config
  providers: [
    ...appConfig.providers,     // 🧠 Spread existing providers from appConfig
    provideHttpClient()         // ✅ Add additional providers like HTTP
  ]
});
