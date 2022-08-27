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
}