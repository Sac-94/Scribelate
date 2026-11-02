# Scribelate 🎙️

An elegant, modern, edge-to-edge Android application that effortlessly converts audio files and chat voice messages into written text in real time. Built with **Kotlin**, **Android Gradle Plugin 9.5+**, and **Material Design 3**.

---

## ✨ Features

- **Seamless Voice Message Share Target**: Share any audio or voice note directly from WhatsApp, Telegram, or other messaging apps straight into Scribelate via the floating bottom overlay—no need to switch out of your chat!
- **Fast & Accurate Speech-to-Text**: Powered by the [ElevenLabs API](https://elevenlabs.io) for high-accuracy speech transcription.
- **Instant Translation Options**:
  - **Google Translate App Integration**: Hand off transcripts directly to the installed Google Translate app (no extra API key needed).
  - **Cloud Translation API**: Translate transcripts directly within the app using your optional Google Cloud API Key.
- **Modern Material Design 3 UI**:
  - **Edge-to-Edge Experience**: Fully transparent system navigation and status bar integration for Android 15+.
  - **Adaptive Icon**: Custom 3D adaptive launcher icon with Android 13+ themed monochrome icon support.
  - **Exposed Dropdown Menus & Linear Progress Indicators**: Clean, accessible M3 input controls and loading indicators.
  - **Dynamic Contrast & Theme Switching**: Full support for Light and Dark themes with automated Material 3 color tokens.
- **Transcription History**: Easily view, copy, share, or manage past transcriptions.

---

## 📱 How to Use

### 1. Scribelate Voice Messages from WhatsApp / Telegram
1. Select a voice message or audio file in any chat app and tap **Share**.
2. Choose **Scribelate**.
3. A sleek floating card opens over your chat displaying the Scribelated text.
4. Tap **Copy**, **Share**, or **Translate** as desired, then dismiss the overlay to return seamlessly to your conversation.

### 2. Scribelate Local Audio Files
1. Open the **Scribelate** app from your home screen or app drawer.
2. Tap **Pick an audio file** to choose any local audio recording.
3. Tap **Process Audio** to Scribelate and translate.

---

## ⚙️ Setup & Requirements

- **Minimum Android Version**: Android 8.0 (API level 26) or higher.
- **API Keys**:
  - Open the app and save your **ElevenLabs API Key** (required for speech-to-text transcription).
  - *(Optional)* Add a **Google Cloud Translation API Key** if you prefer in-app translation over handing off to the Google Translate app.

---

## 🛠️ Tech Stack & Architecture

- **Language**: 100% Idiomatic Kotlin
- **Build System**: Gradle 9.8.2 / AGP 9.5.0 (Built-in Kotlin & Java 21)
- **UI Architecture**: ViewBinding, Material Design 3, Edge-to-Edge Window Insets
- **Asynchronous Execution**: Kotlin Coroutines & Lifecycle Flow
- **Network**: OkHttp 5.x
- **CI/CD**: GitHub Actions (Automated Release APK Generation)

---

## 📦 Building & Releases

To build the APK locally:

```bash
./gradlew assembleRelease
```

The GitHub Actions workflow automatically builds and publishes the latest Release APK artifact under the **Actions** tab on every push to `master`.

---

## 📄 License

Distributed under the Apache License 2.0. See [LICENSE](LICENSE) for details.
