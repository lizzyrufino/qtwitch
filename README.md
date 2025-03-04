# qTwitch

This project aims to create a functional architecture for a streaming platform

## Steps

- [ ] User
  - [x] Create
  - [ ] Update
  - [ ] Delete
  - [ ] List
    - [ ] List with filters
    - [ ] Response paginated
  
  - [ ] Authentication
    - [ ] Generate token
    - [ ] Session manager
    - [ ] Refresh token
    - [ ] Role authorization
    - [ ] Login
    - [ ] Anonymous
  
- [ ] Subscription
  - [ ] Create subscription plan
  - [ ] Generate bill
  - [ ] Execute invoice
  - [ ] History payment

- [ ] Creator profile
  - [ ] Creator info
  - [ ] Relationship video x creator x viewer

- [ ] Video
  - [ ] Viewers management
  - [ ] Timestamp management
  - [ ] Media file
    - [ ] Bucket S3
  - [ ] Comment management
    - [ ] Relationship comment x video x user
  - [ ] Like/Dislike management
    - [ ] Relationship like x dislike x video x user
  - [ ] Real-Time Streaming (Twitch like) ✨ **THIS IS GOING BE A FUCKING CHALLENGE** ✨
    - [ ] Kafka rules 💯💯
    - [ ] RTMP or WebRTC (I haven't decided yet) 🤔

- [ ] Category
  - [ ] Relationship category x video

- [ ] Watch history
  - [ ] Control last watch flag
  - [ ] Control current timestamp videos
