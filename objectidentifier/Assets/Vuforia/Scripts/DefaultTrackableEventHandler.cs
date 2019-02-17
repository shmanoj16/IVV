/*==============================================================================
Copyright (c) 2010-2014 Qualcomm Connected Experiences, Inc.
All Rights Reserved.
Confidential and Proprietary - Protected under copyright and other laws.
==============================================================================*/

using UnityEngine;
using System.Collections;
using System.Collections.Generic;

namespace Vuforia
{
	/// <summary>
	/// A custom handler that implements the ITrackableEventHandler interface.
	/// </summary>
	public class DefaultTrackableEventHandler : MonoBehaviour,
	ITrackableEventHandler
	{
		//------------Begin Sound----------
		public AudioSource soundTarget;
		public AudioClip clipTarget; 
		private AudioSource[] allAudioSources;

		//function to stop all sounds
		void StopAllAudio()
		{
			allAudioSources = FindObjectsOfType(typeof(AudioSource)) as AudioSource[];
			foreach (AudioSource audioS in allAudioSources)
			{
				audioS.Stop();
			}
		}

		//function to play sound
		void playSound(string ss)
		{
			clipTarget = (AudioClip)Resources.Load(ss);
			soundTarget.clip = clipTarget
;			soundTarget.loop = false;
			soundTarget.playOnAwake = false;
			soundTarget.Play();
		}

		//-----------End Sound------------

		#region PRIVATE_MEMBER_VARIABLES

		private TrackableBehaviour mTrackableBehaviour;

		#endregion // PRIVATE_MEMBER_VARIABLES



		#region UNTIY_MONOBEHAVIOUR_METHODS

		void Start()
		{
			mTrackableBehaviour = GetComponent<TrackableBehaviour>();
			if (mTrackableBehaviour)
			{
				mTrackableBehaviour.RegisterTrackableEventHandler(this);
			}
			soundTarget = (AudioSource)gameObject.AddComponent<AudioSource>();

		}

		#endregion // UNTIY_MONOBEHAVIOUR_METHODS



		#region PUBLIC_METHODS

		/// <summary>
		/// Implementation of the ITrackableEventHandler function called when the
		/// tracking state changes.
		/// </summary>
		public void OnTrackableStateChanged(
			TrackableBehaviour.Status previousStatus,
			TrackableBehaviour.Status newStatus)
		{
			if (newStatus == TrackableBehaviour.Status.DETECTED ||
				newStatus == TrackableBehaviour.Status.TRACKED ||
				newStatus == TrackableBehaviour.Status.EXTENDED_TRACKED)
			{
				OnTrackingFound();
			}
			else
			{
				OnTrackingLost();
			}
		}

		#endregion // PUBLIC_METHODS



		#region PRIVATE_METHODS


		private void OnTrackingFound()
		{
			Renderer[] rendererComponents = GetComponentsInChildren<Renderer>(true);
			Collider[] colliderComponents = GetComponentsInChildren<Collider>(true);

			// Enable rendering:
			foreach (Renderer component in rendererComponents)
			{
				component.enabled = true;
			}

			// Enable colliders:
			foreach (Collider component in colliderComponents)
			{
				component.enabled = true;
			}

			Debug.Log("Trackable " + mTrackableBehaviour.TrackableName + " found");

			//Play Sound, IF detect an target

		if (mTrackableBehaviour.TrackableName == "10f")
			{
				playSound("sounds/10");
			}

			if (mTrackableBehaviour.TrackableName == "10b")
			{
				playSound("sounds/10");
			}

			if (mTrackableBehaviour.TrackableName == "100f")
			{
				playSound("sounds/100");
			}
			if (mTrackableBehaviour.TrackableName == "100b")
			{
				playSound("sounds/100");
			}
			if (mTrackableBehaviour.TrackableName == "500f")
			{
				playSound("sounds/500");
			}
			if (mTrackableBehaviour.TrackableName == "500b")
			{
				playSound("sounds/500");
			}

			if (mTrackableBehaviour.TrackableName == "2000nf")
			{
				playSound("sounds/2000");
			}

			if (mTrackableBehaviour.TrackableName == "milkbikif")
			{
				playSound("sounds/britannia");
			}

			if (mTrackableBehaviour.TrackableName == "2000nb")
			{
				playSound("sounds/2000");
			}
		}


		private void OnTrackingLost()
		{
			Renderer[] rendererComponents = GetComponentsInChildren<Renderer>(true);
			Collider[] colliderComponents = GetComponentsInChildren<Collider>(true);

			// Disable rendering:
			foreach (Renderer component in rendererComponents)
			{
				component.enabled = false;
			}

			// Disable colliders:
			foreach (Collider component in colliderComponents)
			{
				component.enabled = false;
			}

			Debug.Log("Trackable " + mTrackableBehaviour.TrackableName + " lost");

			//Stop All Sounds if Target Lost
			StopAllAudio();
		}

		#endregion // PRIVATE_METHODS
	}
}
