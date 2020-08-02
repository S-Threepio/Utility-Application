package com.utility.application.api

data class JokesModel(
    val category: String,
    val type: String,
    val setup: String="thats a bad setup",
    val delivery: String = "really bad man",
    val flags: Flags,
    val id: Int,
    val error: Boolean
)


data class Flags(
    val nsfw: Boolean,
    val religious: Boolean,
    val political: Boolean,
    val racist: Boolean,
    val sexist: Boolean
)


//{
//   "error": true,
//   "internalError": false,
//   "code": "101",
//   "message": "Request blocked by Rate Limiting",
//   "causedBy": [
//       "You have sent too many requests too quickly. The limit is 60 requests within 60 seconds.\nIf you need more requests per minute, please contact me and we can try to figure things out: https://sv443.net/"
//   ],
//   "timestamp": 1596317831708,
//   "additionalInfo": "You are being rate limited because you have sent too many requests. The maximum is 60 requests every 60 seconds."
//}