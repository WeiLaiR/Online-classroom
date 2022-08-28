import request from '@/utils/request'

const api_name = '/admin/vod/teacher'

export default {
	//讲师列表
    pageList(page, limit, searchObj) {
      return request({
        url: `${api_name}/${page}/${limit}`,
        method: `post`,
        data: searchObj
      })
    },

    removeById(id) {
      return request({
        url: `${api_name}/remove/${id}`,
        method: `delete`
      })
    },

    save(teacher) {
      return request({
        url: `${api_name}/save`,
        method: `post`,
        data: teacher
      })
    },

    getById(id) {
      return request({
        url: `${api_name}/get/${id}`,
        method: `get`
      })
    },

    updateById(teacher) {
      return request({
        url: `${api_name}/update`,
        method: `put`,
        data: teacher
      })
    },

    batchRemove(idList) {
      return request({
        url: `${api_name}/batchRemove`,
        method: `delete`,
        data: idList
      })
    },
}