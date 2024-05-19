package com.example.proyectofinal.fragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.example.proyectofinal.R

class NewsFragment : Fragment() {

    private var myVideoView : VideoView? = null
    private var myMediaController: MediaController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myVideoView = view.findViewById(R.id.videoView)

        setUpVideoPlayer()
    }

    private fun setUpVideoPlayer() {
        if (myMediaController == null) {
            myMediaController = MediaController(context)
            myMediaController!!.setAnchorView(myVideoView)
        }

        myVideoView!!.setMediaController(myMediaController)
        myVideoView!!.setVideoURI(
            Uri.parse(
                "android.resource://" + requireActivity().packageName + "/" + R.raw.anuncio
            )
        )

        myVideoView!!.requestFocus()

        myVideoView!!.start() // Puedes iniciar el video automáticamente si deseas

        myVideoView!!.setOnCompletionListener {
        }

        myVideoView!!.setOnErrorListener { mp, what, extra ->
            Toast.makeText(context, "An Error Occurred", Toast.LENGTH_SHORT).show()
            false
        }
    }
}