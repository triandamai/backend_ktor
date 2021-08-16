@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  ktor-gc startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and KTOR_GC_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\ktor-gc-0.0.1.jar;%APP_HOME%\lib\ktor-jackson-jvm-1.6.2.jar;%APP_HOME%\lib\ktor-server-jetty-jvm-1.6.2.jar;%APP_HOME%\lib\ktor-server-servlet-jvm-1.6.2.jar;%APP_HOME%\lib\ktor-server-host-common-jvm-1.6.2.jar;%APP_HOME%\lib\ktor-server-core-jvm-1.6.2.jar;%APP_HOME%\lib\exposed-jdbc-0.33.1.jar;%APP_HOME%\lib\exposed-dao-0.33.1.jar;%APP_HOME%\lib\exposed-core-0.33.1.jar;%APP_HOME%\lib\kotlinx-coroutines-jdk8-1.5.0-native-mt.jar;%APP_HOME%\lib\ktor-http-cio-jvm-1.6.2.jar;%APP_HOME%\lib\ktor-http-jvm-1.6.2.jar;%APP_HOME%\lib\ktor-network-jvm-1.6.2.jar;%APP_HOME%\lib\ktor-utils-jvm-1.6.2.jar;%APP_HOME%\lib\ktor-io-jvm-1.6.2.jar;%APP_HOME%\lib\kotlinx-coroutines-core-jvm-1.5.1.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.5.21.jar;%APP_HOME%\lib\logback-classic-1.2.3.jar;%APP_HOME%\lib\mysql-socket-factory-connector-j-8-1.1.0.jar;%APP_HOME%\lib\mysql-connector-java-8.0.19.jar;%APP_HOME%\lib\HikariCP-3.4.2.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.5.21.jar;%APP_HOME%\lib\jackson-databind-2.12.3.jar;%APP_HOME%\lib\jackson-annotations-2.12.3.jar;%APP_HOME%\lib\jdbc-socket-factory-core-1.1.0.jar;%APP_HOME%\lib\google-auth-library-oauth2-http-0.21.1.jar;%APP_HOME%\lib\google-api-services-sqladmin-v1beta4-rev20190827-1.30.1.jar;%APP_HOME%\lib\google-api-client-1.30.1.jar;%APP_HOME%\lib\google-http-client-jackson2-1.36.0.jar;%APP_HOME%\lib\jackson-core-2.12.3.jar;%APP_HOME%\lib\jackson-module-kotlin-2.12.3.jar;%APP_HOME%\lib\kotlin-reflect-1.5.21.jar;%APP_HOME%\lib\kotlin-stdlib-1.5.21.jar;%APP_HOME%\lib\slf4j-api-1.7.30.jar;%APP_HOME%\lib\config-1.3.1.jar;%APP_HOME%\lib\jetty-alpn-openjdk8-server-9.4.42.v20210604.jar;%APP_HOME%\lib\jetty-alpn-java-server-9.4.42.v20210604.jar;%APP_HOME%\lib\jetty-alpn-server-9.4.42.v20210604.jar;%APP_HOME%\lib\http2-server-9.4.42.v20210604.jar;%APP_HOME%\lib\jetty-server-9.4.42.v20210604.jar;%APP_HOME%\lib\jetty-servlets-9.4.42.v20210604.jar;%APP_HOME%\lib\logback-core-1.2.3.jar;%APP_HOME%\lib\jnr-unixsocket-0.38.0.jar;%APP_HOME%\lib\asm-util-8.0.1.jar;%APP_HOME%\lib\protobuf-java-3.6.1.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.5.21.jar;%APP_HOME%\lib\javax.servlet-api-3.1.0.jar;%APP_HOME%\lib\http2-common-9.4.42.v20210604.jar;%APP_HOME%\lib\http2-hpack-9.4.42.v20210604.jar;%APP_HOME%\lib\jetty-http-9.4.42.v20210604.jar;%APP_HOME%\lib\jetty-io-9.4.42.v20210604.jar;%APP_HOME%\lib\jetty-continuation-9.4.42.v20210604.jar;%APP_HOME%\lib\jetty-util-9.4.42.v20210604.jar;%APP_HOME%\lib\jnr-enxio-0.32.0.jar;%APP_HOME%\lib\jnr-posix-3.1.0.jar;%APP_HOME%\lib\jnr-ffi-2.2.0.jar;%APP_HOME%\lib\jnr-constants-0.10.0.jar;%APP_HOME%\lib\asm-commons-7.1.jar;%APP_HOME%\lib\asm-analysis-8.0.1.jar;%APP_HOME%\lib\asm-tree-8.0.1.jar;%APP_HOME%\lib\asm-8.0.1.jar;%APP_HOME%\lib\auto-value-annotations-1.7.2.jar;%APP_HOME%\lib\google-oauth-client-1.30.1.jar;%APP_HOME%\lib\google-http-client-1.36.0.jar;%APP_HOME%\lib\opencensus-contrib-http-util-0.24.0.jar;%APP_HOME%\lib\guava-29.0-android.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\google-auth-library-credentials-0.21.1.jar;%APP_HOME%\lib\jffi-1.3.0.jar;%APP_HOME%\lib\jffi-1.3.0-native.jar;%APP_HOME%\lib\jnr-a64asm-1.0.0.jar;%APP_HOME%\lib\jnr-x86asm-1.0.2.jar;%APP_HOME%\lib\httpclient-4.5.12.jar;%APP_HOME%\lib\httpcore-4.4.13.jar;%APP_HOME%\lib\j2objc-annotations-1.3.jar;%APP_HOME%\lib\opencensus-api-0.24.0.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\checker-compat-qual-2.5.5.jar;%APP_HOME%\lib\error_prone_annotations-2.3.4.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\commons-codec-1.11.jar;%APP_HOME%\lib\grpc-context-1.22.1.jar


@rem Execute ktor-gc
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %KTOR_GC_OPTS%  -classpath "%CLASSPATH%" io.ktor.server.jetty.EngineMain %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable KTOR_GC_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%KTOR_GC_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
