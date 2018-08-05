% Read a sample audio file
speechSignal = audioread('speech_dft.wav'); % Use wavread() if audioread() is not supported
% Plot the signal
plot(speechSignal);
title('DFT Speech signal');

% Play audio at 22000 Hz
soundsc(speechSignal, 22000);

%{
Sample files depend on your Matlab version
If you get a file not found error, use another sample file
Sample files location MatlabInstallDirectory/toolbox
       eg. C:\Program Files\Matlab\toolbox\dsp\dsp
%}