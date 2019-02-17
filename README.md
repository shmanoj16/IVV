# IVV

ABSTRACT:

Currently, visually impaired are also using smartphones, the existing applications are user-friendly but not for visually impaired.  To simplify the usage of application we propose an innovative and essentials need for them using the four swiping gestures. The gestures are swiping up, right, down and left for performing the various activities. The activities are indoor navigation using inbuilt speakers and mic (VIA ULTRASONIC SOUND WAVE), object detection which identifies the object, bus stop locator for knowing the current bus stop names and distance between the adjacent stops and transaction of money in ATM using the barcode scanner without the help of others in secured way. The main objective of this project is to make use of various visual substitution activities in single and user – friendly device (Smart phone). This helps to perform their routine task in day to day life that persons with normal vision would do using their eye.
INTRODUCTION: 
Blindness has been recognized as an important public health problem in India. Mobility of visually impaired people is restricted by their incapability to recognize their surroundings. According to World Health Organization (WHO) in 2016, out of 7.5 billion global population there were over 285 million visually impaired people and 39 million were totally blind out of which 19 million are children. Among these India has the largest burden of global blindness, about 3.5 million across the country with 30000 new cases being added each year.  The world is loaded with risks and ponders which society accepts the utilization if vision to maintain a distance from risk, being visually impaired limits their exposures and expands their risk to the perils. Our point is to add to make their lives ordinary in the way that we can.







OBJECTIVE & IMPLEMENTATION OF THE PROJECT:
 OBSTACLE DETECTION (INDOOR):
          The user can enter this activity by Swiping UP. In this activity to reduce the navigation difficulties of the blind, an obstacle detection system using vibrators and ultrasonic wave is used. This is portable and detects the nearest obstacle and sends back vibrant feedback that intimates to take another way. The process behind this activity is, the obstacles can be detected by passing a constant ultrasonic waves (i.e., 15Hz). Normally the frequency of a reflected wave of an Obstacle is greater than the original frequency .Based on this concept, obstacles are detected. The ultrasonic wave is transmitted through the inbuilt speakers and it is monitored through the microphone. If some Obstacle is detected, the transmitted ultrasonic wave is repelled back and produces a greater frequency which is above 15Hz.
 


This triggers the haptic feedback such that the impaired person gets aware of the Obstacle. On other hand, if there is no Obstacle, the Produced frequency will be lesser than that of Actual frequency and thus triggering pulse stops. (This concept is based on BAT logic).
 




  BUS NAVIGATION:
                  The user can enter this activity by Swiping RIGHT. There are many techniques which are used for navigating the visually challenged people, but the navigation in the real time traffic and finding the exact location of the impaired person is the main problem. The main objective of this activity is to help the visually impaired people to identify the bus stop names without the help of others and also to provide the visually impaired person’s current location to their care takers. This can be done with the help of wireless sensor networks (WSNs). TTS is used to update and inform the blind person about the adjacent bus stop names and guides them to know their destination. The audio output is given by the voice synthesizer. Here, the latitude and longitudinal co-ordinates are obtained in the map. And this provides the information about the current location to the care takers. It also provides all the places travelled by that particular person with time any more additional attributes like date, speed etc.
 
 However the issues of route for the visually impaired are still exceptionally mind boggling and troublesome particularly when they explore to inaccessible stops by general transport system. It utilizes both GPS and network access to obtain the exact location of the impaired person. Each visually impaired person is provided with a unique id (say Aadhaar id) using this ID the care taker can find the realistic location of their arrival and destination. A separate record is maintained about the location and the travelling details of the visually impaired person for future reference. Hence with this proposed activity, a visually impaired person can successfully travel from their location to ant desired destination independently.
 
  OBJECT IDENTIFIER:
          The user can enter this activity by Swiping DOWN.This activity enables the visually impaired person to recognize and identify various objects. When the person wants to know “what the Object is”, he/she takes a picture of that object (via phone camera) and that particular object is uploaded into the Google images automatically.
 
This fetches the relevant information of that object and gives an appropriate answer in the search tab. This answer is provided as an output (through voice) to the visually impaired person. Using this, the person can recognize any type of objects such as apple, toothpaste, Money, dollar, hardware devices etc.
 ATM:
             The user can enter this activity by Swiping LEFT .The main objective of this activity is to provide ease of accessing ATM by visually impaired people. Initially, the impaired person inserts the ATM card into the ATM machine, the machine generates a QR code of a secured tunnel (based on the card details).When the person scans this QR code, he/she is redirected to the secured link (via 128 bit encryption). The scanning is done using the mobile camera. Now the link requests the user to enter the pin to start any type of transaction related activities. The person enters the pin with the help of vibrate feedback (for example, when the user wants to enter “2” the device vibrates twice). This vibrate feedback is for the security purpose of the pin. Once the correct pin is entered, the person can perform any kind of bank related activities such as withdrawal, fast cash, pin change, enquiry, balance etc.,
 
MARKET POTENTIAL AND COMPETITIVE ADVANTAGE:
          This android application does not require any special add-ons like arduino board, sensor’s or other hardware resources (i.e., consumes very less resources and requires no specialized sensors).More over this application is compatible with any android version starting from android 4.0(ICE-CREAM SANDWICH). User – friendly interactions with the user. Easy to use. Audio and vibration alert. Our android app consists of four different activities combined in one application. This app can also be used as a launcher application.
INNOVATIVENESS AND USEFULNESS:
          The main aim of this project is to make the visually impaired Person to perform various activities that a normal person can do with an ease using their Smart Phone. And even the Visually Impaired people have their own goals and this APP helps them to take a step forward to achieve their success.  And our ultimate GOAL is to make VISION LESS WORLD (IN SMARTER WAY). The ability of ATM Transaction for blind removes their inferiority complex (that they can’t do anything without eyes) and improves their self-confidence (that they can do each and every essential things even without eyes).
SCREEN SHOTS: 
 OBSTACLE DETECTION - INDOOR:
i) Constant Sound                                       ii) Vibrate, once it crosses constant Sound                                                                                                                                                                   
                                      
                                                                

  OBJECT IDENTIFIER: 
i) Capturing image via camera                 ii) Uploading to Google, and waiting for response
                                                                   
 iii)        After getting response, user can hear the name of the object. 





 ATM:
i) User must scan the QR Code from an ATM machine.
 
ii) User can enter the PIN number using haptic feedback. 
               
                        
*By using this app the visually impaired can perform various task start from amount withdrawal to enquiry status. (WITHOUT ANYONE’S HELP).

iii)User can enter their desired amount (via TTS guidance) and complete the transaction. 

                                            



  BUS NAVIGATION: 
i) Bus Stop Teller: 
* Various Bus stops were marked in OMR. It tells the Bus stop name and the distance between the adjacent stops. 
* This bus stop teller activity facilitates the user to know the exact bus stops using TTS without asking others.
* This marked bus stops are prototype for understanding purpose, similarly we can implement this idea all over the world.


                                    

 
ii)User Tracker : 
* Caretaker can easily get the precise location of the user by various time-limits (1 minute, 5 minute and 15 minute interval) via user’s Aadhar ID. It also tells the places travelled by that person with additional attributes like speed, date, time etc.
i) Caretaker need to enter                                             ii) Caretaker need set interval time limit                                                                User’s Aadhar ID                                                                        to track the user
                                     


iii) Caretaker need to enter registered                     iii) Now the caretaker will get precise user  User’s Aadhar id                                                location of the (including update time,        .                                                                        speed (via accelerometer) and accuracy)                                                                                                                                            
                                      

CONCLUSION:
  Blind people might be unwilling to move easily and openly, society limits the development of the visually impaired people. In this document, we have proposed new intelligent system for guiding and handlings their essential tasks of individuals who are visually impaired. If this app is developed and implemented, it will act as a basic platform for the future generation of visually impaired. The experimental results have shown the usefulness of the application in allowing blind people to move independently, safely and quickly among obstacle. Thus the project is present day concept and hence supports innovation of the existing tasks.

REFERENCES:
[1] Shripad S. Bhatlawande, Jayant Mukhopadhyay and Manjunatha
Mahadevappa, “Ultrasonic Spectacles and Waist-belt for Visually
Impaired and Blind Person”, Communications (NCC), National
Conference on Kharagpur, pp no.978-1-4673-0815-1. 2012
[2] C. Jackson, 1995, Correspondence with Carroll L. Jackson,
Executive Director of the Upshaw Institute for the Blind, August
1995.
[3] Ran L, Helal S, Moore S, “Drishti: an integrated indoor/outdoor
blind navigation system and service.”, Proceedings of the Second
IEEE Annual Conference on Pervasive Computing and
Communications, pp 23 – 30, PerCom 2004.
[4]  Fernandes H, Costa P, Filipe V, Hadjileontiadis L, Barroso J,
“Stereo vision in blind navigation assistance”, World Automation
Congress (WAC), pp 1-6, 2010.
[5] "Wireless Sensor Networks Research Group".
Sensor-networks.org. 2008-11-17. Retrieved 2012-
10-18.
[6] Oleg Artamonov (2004-10-26)."X-bit’s Guide:
Contemporary LCD Monitor. Parameters and
Characteristics". Xbitlabs.com. Retrieved 2009-08-05
[7] K. H. Lee, H. Y. Kim, K. H. Park, S. J. Jang, I.
C. Park, and J. Y. Lee . "A Novel Outdoor
Readability of Portable TFT-LCD with AFFS
Technology". SID Symposium Digest of
TechnicalPapers(AIP)37(1):1079–82. doi:10.1889/1.2433159
